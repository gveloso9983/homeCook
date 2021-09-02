package com.example.homecookBackend.controllers;
import com.example.homecookBackend.beans.baker_perfil;
import com.example.homecookBackend.beans.cliente_perfil;
import com.example.homecookBackend.classes.client.Client;
import com.example.homecookBackend.classes.client.ClientDAO;
import com.example.homecookBackend.classes.image.Image;
import com.example.homecookBackend.classes.image.ImageDAO;
import com.example.homecookBackend.classes.product.Product;
import com.example.homecookBackend.classes.product.ProductDAO;
import com.example.homecookBackend.config.TokenProvider;
import com.example.homecookBackend.responses.ProductElem;
import com.example.homecookBackend.responses.ProductListElem;
import com.example.homecookBackend.responses.ProductsListElemTotal;
import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.homecookBackend.beans.product_perfil;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.valueOf;

@RestController
@RequestMapping("/products")
public class ProductListing {

    @Autowired
    private TokenProvider tk;

    @RolesAllowed("ROLE_BAKER")
    @CrossOrigin
    @PostMapping("/")
    public ResponseEntity registerProduct(@RequestParam("files") MultipartFile[] files, @RequestHeader String Authorization, @RequestParam String name,
                                          @RequestParam Integer categoryId, @RequestParam String description,@RequestParam String ingredients,
                                          @RequestParam Float price, @RequestParam Float weight){

        String token = Authorization.substring(7);
        try {

            Product p = product_perfil.register(categoryId, tk.getUsernameFromToken(token),name,description,ingredients,price,weight);
            File theDir = new File("src/main/resources/images/"+p.getId());
            if (!theDir.exists()){
                theDir.mkdirs();
            }

            ArrayList<Image> imagens = new ArrayList<>();

            for (MultipartFile f: files) {

                Image i = ImageDAO.createImage();
                i.setPath("src/main/resources/images/"+p.getId()+"/"+f.getOriginalFilename());

                File copied = new File("src/main/resources/images/"+p.getId()+"/"+f.getOriginalFilename());
                Files.copy(f.getInputStream(), Paths.get("src/main/resources/images/"+p.getId()+"/"+f.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
                p.images.add(i);
                imagens.add(i);
            }
            ProductDAO.save(p);

            for (Image i: imagens) {
                ImageDAO.save(i);
            }
            return ResponseEntity.ok().body("Produto criado com sucesso");


        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Produto não encontrado");

        }

    }

    @RolesAllowed("ROLE_BAKER")
    @CrossOrigin
    @PutMapping("/{prod_id}")
    public ResponseEntity alterProduct(@PathVariable Integer prod_id,@RequestHeader String Authorization, @RequestParam String name,
                                       @RequestParam Integer categoryId, @RequestParam String description,
                                       @RequestParam String ingredients, @RequestParam Float price,
                                       @RequestParam Float weight, @RequestParam("files") MultipartFile[] files, @RequestParam("addedfiles") ArrayList<String> addedfiles){

        String token = Authorization.substring(7);
        try {
            product_perfil.alter(prod_id, categoryId, tk.getUsernameFromToken(token), name, description, ingredients, price, weight);
            Product p = ProductDAO.getProductByORMID(prod_id);
            File theDir = new File("src/main/resources/images/"+prod_id);
            if (!theDir.exists()) {
                theDir.mkdirs();
            }
            File[] listOfFiles = theDir.listFiles();
            ArrayList<String> dirFileNames = new ArrayList<String>();

            for (File listOfFile : listOfFiles) {
                dirFileNames.add(listOfFile.getName());
            }


            for (String fileName: dirFileNames) {
                if (!addedfiles.contains(fileName)){
                    try {
                        Files.deleteIfExists(Paths.get("src/main/resources/images/"+p.getId()+"/"+fileName));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        Image imageToDelete = ImageDAO.loadImageByQuery("Path = '" + "src/main/resources/images/"+p.getId()+"/"+fileName+"'", null);
                        if (imageToDelete != null){
                            p.images.remove(imageToDelete);
                            ImageDAO.delete(imageToDelete);
                        }
                    } catch (PersistentException e) {
                        e.printStackTrace();
                    }
                }
            }

            ArrayList<Image> images = new ArrayList<>();
            for (MultipartFile f: files) {
                Image i = ImageDAO.createImage();
                i.setPath("src/main/resources/images/"+p.getId()+"/"+f.getOriginalFilename());
                File copied = new File("src/main/resources/images/"+p.getId()+"/"+f.getOriginalFilename());
                Files.copy(f.getInputStream(), Paths.get("src/main/resources/images/"+p.getId()+"/"+f.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
                p.images.add(i);
                images.add(i);

            }
            ProductDAO.save(p);

            for (Image i: images) {
                ImageDAO.save(i);
            }


            product_perfil.alter(prod_id, categoryId, tk.getUsernameFromToken(token), name, description, ingredients, price, weight);
            return ResponseEntity.ok().body("Produto alterado com sucesso");


        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body("Produto não encontrado");

        }

    }

    @RolesAllowed("ROLE_BAKER")
    @CrossOrigin
    @PutMapping("/{prod_id}/saleStatus")
    public ResponseEntity deleteProduct(@RequestHeader String Authorization,@RequestBody Map<String,Object> body,@PathVariable Integer prod_id){
        Boolean onSale = Boolean.parseBoolean((String) body.get("onSale"));
        String token = Authorization.substring(7);

        if(onSale==null){
            return ResponseEntity.badRequest().body("Valor Inválido");
        }

        try {

            baker_perfil.changeProductStatus(tk.getUsernameFromToken(token), prod_id, onSale);
            return ResponseEntity.ok().body("Mudado com sucesso");

        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body("Produto não encontrado");

        }

    }

    @CrossOrigin
    @GetMapping("/list")
    public ResponseEntity list(@RequestParam("page") Optional<Integer> page,
                               @RequestParam("category") Optional<Integer> category,
                               @RequestParam("order_by") Optional<String> order_by,
                               @RequestParam("sort") Optional<String> sort,
                               @RequestParam("prices") Optional<String> prices,
                               @RequestParam("ratings") Optional<String> ratings,
                               @RequestParam("categories") Optional<String> categories,
                               @RequestParam("name") Optional<String> productName,
                               @RequestParam("limit") Optional<Integer> limit
    ){
        ArrayList<ProductListElem> res = null;
        ProductsListElemTotal productsListElemTotal = null;
        int total = 0;
        try {
            if (category.isEmpty()){
                res = product_perfil.getProducts(page.orElse(1), order_by.orElse("id"),sort.orElse("desc"), limit.orElse(20),
                        prices.orElse(""), ratings.orElse(""), categories.orElse(""), productName.orElse(""));
                total = product_perfil.getProductsTotal(page.orElse(1), order_by.orElse("id"),sort.orElse("desc"), 2000,
                        prices.orElse(""), ratings.orElse(""), categories.orElse(""), productName.orElse(""));

                productsListElemTotal = new ProductsListElemTotal(total, res);
                return ResponseEntity.ok().body(productsListElemTotal);
            }else{
                res = product_perfil.getProductsCategory(page.orElse(1), order_by.orElse("id"),category.get(),sort.orElse("desc"), limit.orElse(20));

                productsListElemTotal = new ProductsListElemTotal(total, res);
                return ResponseEntity.ok().body(productsListElemTotal);
            }
        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Erro Interno");
        }

    }

    @CrossOrigin
    @GetMapping("/{prod_id}")
    public ResponseEntity getProd(@PathVariable Integer prod_id){
        try {
            ProductElem p = product_perfil.getProd(prod_id);

            if (p == null) return ResponseEntity.notFound().build();

            return ResponseEntity.ok().body(p);
        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @RolesAllowed("ROLE_USER")
    @CrossOrigin
    @PostMapping("/createComment")
    public ResponseEntity addComment(@RequestHeader String Authorization,@RequestBody Map<String,Object> body){
        try {
            String token = Authorization.substring(7);
            int productId = (int) body.get("productId");

            String currentDate = (String) body.get("date");

            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(currentDate);
            Float rate = Float.parseFloat(body.get("rate").toString());
            String comment = (String) body.get("comment");

            product_perfil.createComment(tk.getUsernameFromToken(token), productId, date, rate, comment);
            return ResponseEntity.ok().body("Operação efetuada com sucesso");
        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().body("Não foi possível processar o pedido");
        } catch (ParseException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().body("A data inserida não se encontra no formato correto");
        }
    }

    @RolesAllowed("ROLE_BAKER")
    @CrossOrigin
    @PutMapping("/partialEdit")
    public ResponseEntity editRegister(@RequestHeader String Authorization, @RequestBody Map<String,Object> body){
        try {
            System.out.println(body);
            String name = (String) body.get("name");
            Float weight = Float.parseFloat(body.get("weight").toString());
            Integer catId = (Integer) body.get("catId");
            Float price = Float.parseFloat(body.get("price").toString());
            Integer prodId = (Integer) body.get("prodId");

            String token = Authorization.substring(7);

            if(name==null || name.length()==0){
                return ResponseEntity.badRequest().body("Nome do produto não preenchido");
            }
            if(weight==null){
                return ResponseEntity.badRequest().body("Peso não preenchido");
            }
            if(catId==null){
                return ResponseEntity.badRequest().body("Categoria não preenchida");
            }
            if(prodId==null){
                return ResponseEntity.badRequest().body("Categoria não preenchida");
            }

            if(price==null){
                return ResponseEntity.badRequest().body("Preço não preenchido");
            }

            product_perfil.parcialEdit(name, weight, catId, price, tk.getUsernameFromToken(token), prodId);

            return ResponseEntity.ok().body("Operação efetuada com sucesso");

        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().body("Não foi possivel processar o pedido em questão");
        }
    }

}

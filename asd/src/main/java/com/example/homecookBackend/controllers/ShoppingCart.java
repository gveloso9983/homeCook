package com.example.homecookBackend.controllers;

import com.example.homecookBackend.beans.cliente_perfil;
import com.example.homecookBackend.classes.cart_line.Cart_line;
import com.example.homecookBackend.classes.cart_line.Cart_lineDAO;
import com.example.homecookBackend.config.TokenProvider;
import com.example.homecookBackend.responses.CartElem;
import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import static java.lang.Integer.valueOf;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCart {

    @Autowired
    private TokenProvider tk;

    @RolesAllowed("ROLE_USER")
    @CrossOrigin
    @GetMapping("/")
    public ResponseEntity getLines(@RequestHeader String Authorization){
        String token = Authorization.substring(7);
        try {
            ArrayList<CartElem> res = cliente_perfil.listShoppingCart(tk.getUsernameFromToken(token));
            return ResponseEntity.ok().body(res);
        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }

    /*
    @RolesAllowed("ROLE_USER")
    @CrossOrigin
    @GetMapping("/{line_id}")
    public ResponseEntity getLine(@PathVariable Integer line_id){
        try {
            Cart_line c = Cart_lineDAO.getCart_lineByORMID(line_id);
            return ResponseEntity.ok().body(c);
        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }*/


    @RolesAllowed("ROLE_USER")
    @CrossOrigin
    @PostMapping("/")
    public ResponseEntity addLine(@RequestHeader String Authorization,@RequestBody Map<String,Object> body){
        String token = Authorization.substring(7);

        Integer productId = valueOf((String) body.get("productId"));
        Integer quantity = valueOf((String) body.get("quantity"));

        if(quantity==null || quantity<=0){
            return ResponseEntity.badRequest().body("Quantidade Inválida");
        }
        if(productId==null){
            return ResponseEntity.badRequest().body("ProductIdInválido");
        }

        try {
            cliente_perfil.addLineShoppingCart(tk.getUsernameFromToken(token),productId,quantity);
            return ResponseEntity.ok().body("Operação efetuada com sucesso");
        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().body("Não foi possivél realizar a operação em causa");
        }
    }

    @RolesAllowed("ROLE_USER")
    @CrossOrigin
    @PostMapping("/buy")
    public ResponseEntity comprar(@RequestHeader String Authorization,@RequestBody Map<String,Object> body){
        try {
            String token = Authorization.substring(7);

            int addressId = (Integer) body.get("addressId");

            String delivery = (String) body.get("deliveryDate");

            if(delivery==null || delivery.length()==0){
                return ResponseEntity.badRequest().body("Data de entrega não preenchida");
            }

            if(addressId == -1){
                return ResponseEntity.badRequest().body("Morada Inválida");
            }

            Date deliveryDate = new SimpleDateFormat("yyyy-MM-dd").parse(delivery);

            long gap = ChronoUnit.DAYS.between(LocalDate.now(), deliveryDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            //Period period = Period.between( LocalDate.now(), deliveryDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

            if(gap < 5){
                return ResponseEntity.badRequest().body("Data de entrega não válida");
            }


            cliente_perfil.comprar(tk.getUsernameFromToken(token),addressId, deliveryDate);

            return ResponseEntity.ok().body("Operação efetuada com sucesso");
        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().body("Não foi possivél realizar a operação em causa");
        } catch (ParseException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().body("A data inserida não se encontra no formato correto");
        }
    }

    @RolesAllowed("ROLE_USER")
    @CrossOrigin
    @PutMapping("/{line_id}")
    public ResponseEntity updateLine(@RequestHeader String Authorization,@RequestBody Map<String,Object> body,@PathVariable Integer line_id){
        String token = Authorization.substring(7);

        Integer quantity = valueOf((String) body.get("quantity"));

        if(quantity==null || quantity<=0){
            return ResponseEntity.badRequest().body("Quantidade Inválida");
        }

        try {
            cliente_perfil.updateLineShoppingCart(tk.getUsernameFromToken(token),line_id,quantity);
            return ResponseEntity.ok().body("Operação efetuada com sucesso");
        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().body("Não foi possivél processar o pedido");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return ResponseEntity.status(401).body("Não permissão para apager este item");
        }
    }

    @RolesAllowed("ROLE_USER")
    @CrossOrigin()
    @DeleteMapping("/{line_id}")
    public ResponseEntity deleteLine(@RequestHeader String Authorization,@PathVariable Integer line_id){
        String token = Authorization.substring(7);

        try {
            cliente_perfil.deleteLineShoppingCart(tk.getUsernameFromToken(token), line_id);
            return ResponseEntity.ok().body("Operação efetuada com sucesso");
        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().body("Não foi possivél processar o pedido");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return ResponseEntity.status(401).body("Não permissão para apager este item");
        }
    }

}

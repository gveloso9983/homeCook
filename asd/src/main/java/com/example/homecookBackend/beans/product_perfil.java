package com.example.homecookBackend.beans;

import com.example.homecookBackend.classes.baker.Baker;
import com.example.homecookBackend.classes.baker.BakerDAO;
import com.example.homecookBackend.classes.category.Category;
import com.example.homecookBackend.classes.category.CategoryCriteria;
import com.example.homecookBackend.classes.category.CategoryDAO;
import com.example.homecookBackend.classes.client.Client;
import com.example.homecookBackend.classes.client.ClientDAO;
import com.example.homecookBackend.classes.comment.Comment;
import com.example.homecookBackend.classes.comment.CommentDAO;
import com.example.homecookBackend.classes.image.Image;
import com.example.homecookBackend.classes.invoice.Invoice;
import com.example.homecookBackend.classes.invoice.InvoiceDAO;
import com.example.homecookBackend.classes.invoice_line.Invoice_line;
import com.example.homecookBackend.classes.product.Product;
import com.example.homecookBackend.classes.product.ProductCriteria;
import com.example.homecookBackend.classes.product.ProductDAO;
import com.example.homecookBackend.responses.CommentElem;
import com.example.homecookBackend.responses.ProductElem;
import com.example.homecookBackend.responses.ProductListElem;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class product_perfil {

    public static Product register(int categoryId, String email, String name, String description, String ingridients, float price, float weight) throws PersistentException {
        Baker b = baker_perfil.bakerFromEmail(email);
        Category c = CategoryDAO.getCategoryByORMID(categoryId);
        Product p = ProductDAO.createProduct();

        p.setCategory(c);
        p.setDescription(description);
        p.setOnSale(true);
        p.setWeight(weight);
        p.setPrice(price);
        p.setIngredients(ingridients);
        p.setName(name);
        p.setRating(0);
        p.setNumber_ratings(0);
        p.setBaker(b);

        b.products.add(p);

        BakerDAO.save(b);
        ProductDAO.save(p);
        ProductDAO.refresh(p);
        return p;
    }

    public static void alter(int prod_id, int categoryId, String email, String name, String description, String ingridients, float price, float weight) throws PersistentException, IllegalAccessException {
        Baker b = baker_perfil.bakerFromEmail(email);
        Category c = CategoryDAO.getCategoryByORMID(categoryId);
        Product p = ProductDAO.getProductByORMID(prod_id);

        if(b.products.contains(p)){
            p.setCategory(c);
            p.setDescription(description);
            p.setWeight(weight);
            p.setPrice(price);
            p.setIngredients(ingridients);
            p.setName(name);

            ProductDAO.save(p);
        }
        else{
            throw new IllegalAccessException();
        }
        return;
    }

    public static ArrayList<ProductListElem> getProducts(int page,String order, String sort, int limit, String price, String rating, String categories,
                                                         String productName) throws PersistentException{
        ArrayList<ProductListElem> list = new ArrayList<>();

        ProductCriteria prod = new ProductCriteria();
        prod.onSale.eq(true);
        prod.setFirstResult((page-1)*limit);
        prod.setMaxResults(limit);
        if(sort.toLowerCase().equals("desc")) {
            prod.addOrder(Order.desc(order));
        }else if (sort.toLowerCase().equals("asc")){
            prod.addOrder(Order.asc(order));
        }
        if(categories!= null && !categories.trim().isEmpty())
        {
            String[] strCategories = categories.split(",");
            int[] intCategories = new int[strCategories.length];
            for(int i = 0; i < strCategories.length; i++) {
                intCategories[i] = Integer.parseInt(strCategories[i]);
            }
            prod.categoryId.in(intCategories);
        }
        if(price!= null && !price.trim().isEmpty()){
            String[] prices = price.split(",");
            prod.price.between(Float.parseFloat(prices[0]), Float.parseFloat(prices[1]));
        }
        if(productName!= null && !productName.trim().isEmpty()){
            prod.add(Restrictions.ilike("name", "%" + productName + "%"));
            //prod.description.ilike(productName);
        }
        if(rating!= null && !rating.trim().isEmpty()){
            Float floatRating = Float.parseFloat(rating);
            prod.rating.le(floatRating);
        }

        Product[] prods = prod.listProduct();

        for(int i=0; i< prods.length; i++){
            Product p = prods[i];
            Image[] images = p.images.toArray();
            if(images.length>0) {
                list.add(new ProductListElem(p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getWeight(), p.getRating(), images[0].getId(), p.getCategory(), p.getOnSale()));
            }
        }

        return list;
    }

    public static int getProductsTotal(int page,String order, String sort, int limit, String price, String rating, String categories, String productName) throws PersistentException{
        ArrayList<ProductListElem> list = new ArrayList<>();

        ProductCriteria prod = new ProductCriteria();
        prod.onSale.eq(true);
        if(sort.toLowerCase().equals("desc")) {
            prod.addOrder(Order.desc(order));
        }else if (sort.toLowerCase().equals("asc")){
            prod.addOrder(Order.asc(order));
        }
        if(categories!= null && !categories.trim().isEmpty())
        {
            String[] strCategories = categories.split(",");
            int[] intCategories = new int[strCategories.length];
            for(int i = 0; i < strCategories.length; i++) {
                intCategories[i] = Integer.parseInt(strCategories[i]);
            }
            prod.categoryId.in(intCategories);
        }
        if(price!= null && !price.trim().isEmpty()){
            String[] prices = price.split(",");
            prod.price.between(Float.parseFloat(prices[0]), Float.parseFloat(prices[1]));
        }
        if(productName!= null && !productName.trim().isEmpty()){
            prod.add(Restrictions.ilike("name", "%" + productName + "%"));
            //prod.description.ilike(productName);
        }
        if(rating!= null && !rating.trim().isEmpty()){
            Float floatRating = Float.parseFloat(rating);
            prod.rating.le(floatRating);
        }

        Product[] prods = prod.listProduct();

        return prods.length;
    }


    public static void parcialEdit(String name, Float weight, int catId, Float price, String userId, int prodId) throws PersistentException {

        Baker baker = baker_perfil.bakerFromEmail(userId);
        Product product = ProductDAO.getProductByORMID(prodId);
        Category category = CategoryDAO.getCategoryByORMID(catId);

        if(product.getBaker().getId() == baker.getId()){
            product.setName(name);
            product.setWeight(weight);
            product.setCategory(category);
            product.setPrice(price);
            ProductDAO.save(product);
        }


    }

    public static ArrayList<ProductListElem> getProductsCategory(int page,String order,int category,String sort, int limit) throws PersistentException{
        ArrayList<ProductListElem> list = new ArrayList<>();

        ProductCriteria prod = new ProductCriteria();
        prod.onSale.eq(true);
        CategoryCriteria cr = prod.createCategoryCriteria();
        cr.add(Restrictions.eq("id",category));

        prod.setFirstResult((page-1)*limit);
        prod.setMaxResults(limit);
        if(sort.toLowerCase().equals("desc")) {
            prod.addOrder(Order.desc(order));
        }else if (sort.toLowerCase().equals("asc")){
            prod.addOrder(Order.asc(order));
        }
        Product[] prods = prod.listProduct();

        for(int i=0; i< prods.length; i++){
            Product p = prods[i];
            Image[] images = p.images.toArray();
            if(images.length>0) {
                list.add(new ProductListElem(p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getWeight(), p.getRating(),  images[0].getId(), p.getCategory(), p.getOnSale()));
            }
        }

        return list;
    }

    public static ProductElem getProd(int id) throws PersistentException {
        Product product = ProductDAO.getProductByORMID(id);

        if (product == null)  return null;

        ArrayList<CommentElem> comms = new ArrayList<>();
        ArrayList<Integer> images = new ArrayList<>();
        Iterator<Comment> c = product.comments.getIterator();
        while (c.hasNext()){
            Comment at = c.next();
            comms.add(new CommentElem(at.getId(),at.getClient().getFirstName() +" "+ at.getClient().getLastName(), at.getScore(), at.getDate(),at.getComment()));
        }
        Iterator<Image> i = product.images.getIterator();

        while (i.hasNext()){
            Image im = i.next();
            images.add(im.getId());
        }

        return new ProductElem(product.getId(),
                product.getCategory().getId(),
                product.getName(),
                product.getDescription(),
                product.getIngredients(),
                product.getPrice(),
                product.getWeight(),
                product.getRating(),
                comms,
                images,
                product.getOnSale());

    }


    public static void createComment(String email, int productId, Date date, float rate, String comment) throws PersistentException {
        Client client = cliente_perfil.clientFromEmail(email);
        Product product = ProductDAO.getProductByORMID(productId);

        if (product == null || client == null)  return;

        float productRating = product.getRating();
        int numberRatings = product.getNumber_ratings();

        product.setRating(((productRating * numberRatings) + rate) / (numberRatings + 1));
        product.setNumber_ratings(numberRatings + 1);

        Comment c = CommentDAO.createComment();
        c.setClient(client);
        c.setDate(date);
        c.setComment(comment);
        c.setScore(rate);
        product.comments.add(c);
        ProductDAO.save(product);

        CommentDAO.save(c);
    }

    private static ProductElem prodelem(Product p){

        ArrayList<CommentElem> comms = new ArrayList<>();
        ArrayList<Integer> images = new ArrayList<>();

        Iterator<Image> i = p.images.getIterator();

        while (i.hasNext()){
            Image im = i.next();
            images.add(im.getId());
        }
        return new ProductElem(p.getId(),
                p.getCategory().getId(),
                p.getName(),
                p.getDescription(),
                p.getIngredients(),
                p.getPrice(),
                p.getWeight(),
                p.getRating(),
                comms,
                images,
                p.getOnSale());
    }

    public static List<ProductElem> getUserProds( String email) throws PersistentException {
        Client c = cliente_perfil.clientFromEmail(email);
        ArrayList<Product> arrayList = new ArrayList<>();
        Invoice[] invoices = InvoiceDAO.listInvoiceByQuery("ClientId = '" + c.getId() + "'",null);

        for (Invoice invoice : invoices) {
            for (Invoice_line invoice_line : invoice.invoice_lines.toArray()) {
                arrayList.add(invoice_line.getProduct());
            }
        }

        List<ProductElem> uniqueProducts = arrayList.stream().distinct().map(p -> product_perfil.prodelem(p)).collect(Collectors.toList());

        return uniqueProducts;
    }

}

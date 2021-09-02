package com.example.homecookBackend.beans;

import com.example.homecookBackend.classes.address.Address;
import com.example.homecookBackend.classes.address.AddressDAO;
import com.example.homecookBackend.classes.baker.Baker;
import com.example.homecookBackend.classes.baker.BakerDAO;
import com.example.homecookBackend.classes.client.Client;
import com.example.homecookBackend.classes.image.Image;
import com.example.homecookBackend.classes.invoice_line.Invoice_line;
import com.example.homecookBackend.classes.invoice_line.Invoice_lineDAO;
import com.example.homecookBackend.classes.product.Product;
import com.example.homecookBackend.classes.product.ProductDAO;
import com.example.homecookBackend.controllers.Invoice;
import com.example.homecookBackend.responses.AddressElem;
import com.example.homecookBackend.responses.OrderElem;
import com.example.homecookBackend.responses.ProductListElem;
import org.orm.PersistentException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

@Service
public class baker_perfil {
    public static void register(String firstName, String lastName, String Email, String phonenumber, String password, Date birth) throws PersistentException {
        Baker c = BakerDAO.createBaker();
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setEmail(Email);
        c.setPhoneNumber(phonenumber);
        c.setPassword(password);
        c.setBirthDate(birth);
        BakerDAO.save(c);
    };

    public static ArrayList<ProductListElem> listProds(String email) throws PersistentException {
        ArrayList<ProductListElem> list = new ArrayList<>();
        Baker b = bakerFromEmail(email);
        Iterator<Product> ip = b.products.getIterator();
        while (ip.hasNext()){
            Product p = ip.next();
            Image[] images = p.images.toArray();
            if(images.length>0) {
                list.add(new ProductListElem(p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getWeight(), p.getRating(),  images[0].getId(), p.getCategory(), p.getOnSale()));
            }
        }
        return list;
    }

    public static void changeProductStatus(String email, int prodId,boolean status) throws PersistentException, IllegalAccessException {
        Product p = ProductDAO.getProductByORMID(prodId);
        Baker b = bakerFromEmail(email);
        if(b.products.contains(p)){
            p.setOnSale(status);
            ProductDAO.save(p);
        }
        else{
            throw new IllegalAccessException();
        }
        return;
    }

    public static void changeInvoice_lineStatus(String email, int lineId,boolean done) throws PersistentException, IllegalAccessException {
        Invoice_line i = Invoice_lineDAO.getInvoice_lineByORMID(lineId);
        Baker b = bakerFromEmail(email);
        if(b.orders.contains(i)){
            i.setDone(done);
            Invoice_lineDAO.save(i);
        }
        else{
            throw new IllegalAccessException();
        }
        return;
    }

    public static Baker bakerFromEmail(String email) throws PersistentException {
        Baker[] bakers = BakerDAO.listBakerByQuery("Email = '" + email + "'",null);
        if(bakers.length >0) {
            return bakers[0];
        }
        return new Baker();
    }

    public static ArrayList<OrderElem> ordersToDo(String email) throws PersistentException {
        Baker b = bakerFromEmail(email);
        ArrayList<OrderElem> res = new ArrayList<>();
        for (Invoice_line il: b.orders.toArray()) {
            if(!il.getDone()){
                AddressElem a = new AddressElem(il.getInvoice().getAddress().getId(),il.getInvoice().getAddress().getStreet(),il.getInvoice().getAddress().getPostalCode(),il.getInvoice().getAddress().getCity());
                res.add(new OrderElem(il.getId(), il.getProduct().getId(),il.getProduct().getName(),il.getQuantity(),il.getInvoice().getDeliveryDate(),a));
            }
        }
        return res;
    }

    public static ArrayList<OrderElem> ordersDone(String email) throws PersistentException {
        Baker b = bakerFromEmail(email);
        ArrayList<OrderElem> res = new ArrayList<>();
        for (Invoice_line il: b.orders.toArray()) {
            if(il.getDone()){
                AddressElem a = new AddressElem(il.getInvoice().getAddress().getId(),il.getInvoice().getAddress().getStreet(),il.getInvoice().getAddress().getPostalCode(),il.getInvoice().getAddress().getCity());
                res.add(new OrderElem(il.getId(), il.getProduct().getId(),il.getProduct().getName(),il.getQuantity(),il.getInvoice().getDeliveryDate(),a));
            }
        }
        return res;
    }

    public static void editRegister(int userId, String firstName, String lastName, String phoneNumber, Date date) throws PersistentException {
        Baker baker = BakerDAO.getBakerByORMID(userId);
        baker.setBirthDate(date);
        //baker.setEmail(email);
        baker.setFirstName(firstName);
        baker.setLastName(lastName);
        baker.setPhoneNumber(phoneNumber);

        BakerDAO.save(baker);

    }
    public static void editPassword(String encodedpass, int userId) throws PersistentException {
        Baker baker = BakerDAO.getBakerByORMID(userId);
        baker.setPassword(encodedpass);
        BakerDAO.save(baker);
    }




}

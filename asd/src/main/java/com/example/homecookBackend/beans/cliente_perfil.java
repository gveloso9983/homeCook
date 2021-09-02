package com.example.homecookBackend.beans;

import com.example.homecookBackend.classes.address.AddressDAO;
import com.example.homecookBackend.classes.baker.Baker;
import com.example.homecookBackend.classes.baker.BakerDAO;
import com.example.homecookBackend.classes.cart_line.Cart_line;
import com.example.homecookBackend.classes.cart_line.Cart_lineDAO;
import com.example.homecookBackend.classes.client.Client;
import com.example.homecookBackend.classes.client.ClientDAO;
import com.example.homecookBackend.classes.image.Image;
import com.example.homecookBackend.classes.invoice.Invoice;
import com.example.homecookBackend.classes.invoice.InvoiceDAO;
import com.example.homecookBackend.classes.invoice_line.Invoice_line;
import com.example.homecookBackend.classes.invoice_line.Invoice_lineDAO;
import com.example.homecookBackend.classes.product.Product;
import com.example.homecookBackend.classes.product.ProductDAO;
import com.example.homecookBackend.classes.address.Address;
import com.example.homecookBackend.responses.*;
import org.orm.PersistentException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

@Service
public class cliente_perfil {

    public static void register(String firstName, String lastName, String Email, String phonenumber, String password, Date birth) throws PersistentException {
            Client c = ClientDAO.createClient();
            c.setFirstName(firstName);
            c.setLastName(lastName);
            c.setEmail(Email);
            c.setPhoneNumber(phonenumber);
            c.setPassword(password);
            c.setBirthDate(birth);
            ClientDAO.save(c);
    }
    public static void editRegister(int userId, String firstName, String lastName, String phoneNumber, Date date) throws PersistentException {
        Client client = ClientDAO.getClientByORMID(userId);
        client.setBirthDate(date);
        //client.setEmail(email);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setPhoneNumber(phoneNumber);

        ClientDAO.save(client);
    }

    public static void editPassword(String encodedpass, int userId) throws PersistentException {
        Client client = ClientDAO.getClientByORMID(userId);
        client.setPassword(encodedpass);
        ClientDAO.save(client);
    }
    public static ArrayList<CartElem> listShoppingCart(String email) throws PersistentException {
        Client c = clientFromEmail(email);
        ArrayList<CartElem> res = new ArrayList<>();
        for (Cart_line l: c.shopping_cart.toArray()) {
            Image[] is = l.getProduct().images.toArray();
            if(is.length>0) {
                res.add(new CartElem(l.getId(), l.getProduct().getId(), l.getProduct().getName(), l.getQuantity(), l.getProduct().getPrice(),is[0].getId()));
            }
        }

        return res;
    }

    public static void comprar(String email, int addressId, Date deliveryDate) throws PersistentException {
        Client c = clientFromEmail(email);
        Invoice i = InvoiceDAO.createInvoice();
        i.setDate(java.sql.Date.valueOf(LocalDate.now()));
        i.setDeliveryDate(deliveryDate);
        float total = 0;
        Address a = AddressDAO.getAddressByORMID(addressId);

        if(c.addresses.contains(a)) {
            i.setAddress(a);
            ArrayList<Invoice_line> linhas = new ArrayList<>();
            ArrayList<Baker> bakers = new ArrayList<>();
            ArrayList<Cart_line> clines = new ArrayList<>();
            for (Cart_line l : c.shopping_cart.toArray()) {
                Invoice_line il = Invoice_lineDAO.createInvoice_line();
                il.setDone(false);
                il.setQuantity(l.getQuantity());
                il.setProduct(l.getProduct());
                il.setInvoice(i);
                i.invoice_lines.add(il);
                total += l.getQuantity() * l.getProduct().getPrice();
                linhas.add(il);

                l.getProduct().getBaker().orders.add(il);
                bakers.add(l.getProduct().getBaker());

                clines.add(l);

                c.shopping_cart.remove(l);

            }
            i.setTotal(total);
            c.invoices.add(i);
            ClientDAO.save(c);
            InvoiceDAO.save(i);

            for (Baker b : bakers) {
                BakerDAO.save(b);
            }
            for (Invoice_line l : linhas) {
                Invoice_lineDAO.save(l);
            }
            for (Cart_line l : clines){
                Cart_lineDAO.delete(l);
            }

        }else{
            throw new IllegalArgumentException();
        }
        return;
    }

    public static ArrayList<InvoiceElem> listarInvoices(String email) throws PersistentException {
        Client c = clientFromEmail(email);

        ArrayList<InvoiceElem> res = new ArrayList<>();

        for (Invoice i: c.invoices.toArray("date", false)) {
            res.add(new InvoiceElem(i.getId(),i.getAddress().getStreet(),i.getAddress().getCity(),i.getTotal(),i.getDate()));
        }

        return res;
    }

    public static InvoiceDetails detailInvoice(String email, int invoiceId) throws PersistentException, IllegalAccessException {
        Client c = clientFromEmail(email);
        Invoice i = InvoiceDAO.getInvoiceByORMID(invoiceId);

        if(c.invoices.contains(i)){
            AddressElem address = new AddressElem(i.getAddress().getId(),i.getAddress().getStreet(), i.getAddress().getPostalCode(),i.getAddress().getCity());

            ArrayList<Invoice_lineElem> lines = new ArrayList<>();

            for (Invoice_line il: i.invoice_lines.toArray()) {
                lines.add( new Invoice_lineElem(il.getId(),il.getProduct().getId(),il.getProduct().getName(),il.getQuantity(),il.getDone(), il.getProduct().getPrice()));
            }

            return new InvoiceDetails(i.getId(),address,i.getTotal(),i.getDate(),lines);
        }else{
            throw new IllegalAccessException();
        }
    }

    public static void addLineShoppingCart(String email, int productId, int quantity) throws PersistentException {
        Client c = clientFromEmail(email);
        Cart_line[] cart = c.shopping_cart.toArray();
        for (Cart_line cart_line : cart) {
            if (cart_line.getProduct().getId() == productId) {
                Cart_line l = cart_line;
                l.setQuantity(l.getQuantity() + quantity);
                Cart_lineDAO.save(l);
                return;
            }
        }
        Product p = ProductDAO.getProductByORMID(productId);

        Cart_line l = Cart_lineDAO.createCart_line();
        l.setQuantity(quantity);
        l.setProduct(p);
        c.shopping_cart.add(l);
        ClientDAO.save(c);
        Cart_lineDAO.save(l);

    }

    public static void updateLineShoppingCart(String email, int cartLineId,int quantity) throws PersistentException, IllegalAccessException {
        Client c = clientFromEmail(email);
        Cart_line l = Cart_lineDAO.getCart_lineByORMID(cartLineId);
        if(c.shopping_cart.contains(l)){
            l.setQuantity(quantity);
            Cart_lineDAO.save(l);
            return;
        }
        throw new IllegalAccessException();
    }

    public static void deleteLineShoppingCart(String email, int cartLineId) throws PersistentException, IllegalAccessException {
        Client c = clientFromEmail(email);
        Cart_line l = Cart_lineDAO.getCart_lineByORMID(cartLineId);
        if(c.shopping_cart.contains(l)){

            c.shopping_cart.remove(l);
            ClientDAO.save(c);
            Cart_lineDAO.delete(l);
            return;
        }
        throw new IllegalAccessException();
    }

    public static AddressElem getAddress(String email, int addressid) throws PersistentException, IllegalAccessException {
        Client c = clientFromEmail(email);
        Address a = AddressDAO.getAddressByORMID(addressid);
        if(c.addresses.contains(a)){
            return new AddressElem(a.getId(),a.getStreet(),a.getPostalCode(),a.getCity());
        }

        throw new IllegalAccessException();
    }

    public static void deleteAddress(String email, int addressid) throws PersistentException, IllegalAccessException {
        Client c = clientFromEmail(email);
        Address a = AddressDAO.getAddressByORMID(addressid);
        if(c.addresses.contains(a)){
            c.addresses.remove(a);
            ClientDAO.save(c);
            AddressDAO.delete(a);
            return;
        }

        throw new IllegalAccessException();
    }

    public static int addAddress(String email, String street, String postalCode, String city) throws PersistentException{
        Client c = clientFromEmail(email);
        Address a = AddressDAO.createAddress();
        a.setStreet(street);
        a.setCity(city);
        a.setPostalCode(postalCode);

        c.addresses.add(a);

        ClientDAO.save(c);
        AddressDAO.save(a);

        AddressDAO.refresh(a);

        return a.getId();
    }

    public static int updateAddress(String email,int addressId ,String street, String postalCode, String city) throws PersistentException{
        Client c = clientFromEmail(email);
        Address a = AddressDAO.getAddressByORMID(addressId);
        if(c.addresses.contains(a)){
            a.setStreet(street);
            a.setCity(city);
            a.setPostalCode(postalCode);
        }

        AddressDAO.save(a);

        return a.getId();
    }

    public static ArrayList<AddressElem> listAddress(String email) throws PersistentException {
        Client c = clientFromEmail(email);
        Iterator<Address> i = c.addresses.getIterator();
        ArrayList<AddressElem> res= new ArrayList<>();
        while (i.hasNext()){
            Address a = i.next();
            res.add(new AddressElem(a.getId(),a.getStreet(),a.getPostalCode(),a.getCity()));
        }
        return res;
    }



    public static Client clientFromEmail(String email) throws PersistentException {
        Client[] clients =ClientDAO.listClientByQuery("Email = '" + email + "'",null);
        if(clients.length >0) {
            return clients[0];
        }
        return new Client();
    }


}

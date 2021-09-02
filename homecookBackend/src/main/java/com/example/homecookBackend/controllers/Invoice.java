package com.example.homecookBackend.controllers;

import com.example.homecookBackend.beans.cliente_perfil;
import com.example.homecookBackend.beans.product_perfil;
import com.example.homecookBackend.classes.cart_line.Cart_line;
import com.example.homecookBackend.classes.cart_line.Cart_lineDAO;
import com.example.homecookBackend.classes.product.Product;
import com.example.homecookBackend.config.TokenProvider;
import com.example.homecookBackend.responses.InvoiceDetails;
import com.example.homecookBackend.responses.InvoiceElem;
import com.example.homecookBackend.responses.ProductElem;
import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class Invoice {
    @Autowired
    private TokenProvider tk;

    @RolesAllowed("ROLE_USER")
    @CrossOrigin
    @GetMapping("/list")
    public ResponseEntity listarInvoices(@RequestHeader String Authorization){
        String token = Authorization.substring(7);
        try {
            ArrayList<InvoiceElem> res = cliente_perfil.listarInvoices(tk.getUsernameFromToken(token));
            return ResponseEntity.ok().body(res);
        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @RolesAllowed("ROLE_USER")
    @CrossOrigin
    @GetMapping("/{invoice_id}")
    public ResponseEntity getLine(@RequestHeader String Authorization,@PathVariable Integer invoice_id){
        String token = Authorization.substring(7);
        try {
            InvoiceDetails invDets =  cliente_perfil.detailInvoice(tk.getUsernameFromToken(token),invoice_id);
            return ResponseEntity.ok().body(invDets);
        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return  ResponseEntity.badRequest().build();
        }

    }

    @RolesAllowed("ROLE_USER")
    @CrossOrigin
    @GetMapping("/products")
    public ResponseEntity getUserProducts(@RequestHeader String Authorization){
        String token = Authorization.substring(7);
        try {
            List<ProductElem> allProducts = product_perfil.getUserProds(tk.getUsernameFromToken(token));
            return ResponseEntity.ok().body(allProducts);
        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}

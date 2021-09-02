package com.example.homecookBackend.controllers;

import com.example.homecookBackend.beans.baker_perfil;
import com.example.homecookBackend.config.TokenProvider;
import com.example.homecookBackend.responses.OrderElem;
import com.example.homecookBackend.responses.ProductListElem;
import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.swing.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/baker")
public class Baker {

    @Autowired
    private TokenProvider tk;

    @RolesAllowed("ROLE_BAKER")
    @CrossOrigin
    @GetMapping("/products")
    public ResponseEntity getProds(@RequestHeader String Authorization){
        ArrayList<ProductListElem> res= new ArrayList<>();
        String token = Authorization.substring(7);
        try {
            res = baker_perfil.listProds(tk.getUsernameFromToken(token));
        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().body("Não foi possivél processar o pedido");
        }
        return ResponseEntity.ok().body(res);
    }


    @RolesAllowed("ROLE_BAKER")
    @CrossOrigin
    @GetMapping("/orders/toDo")
    public ResponseEntity getOrdersToDo(@RequestHeader String Authorization){
        String token = Authorization.substring(7);
        ArrayList<OrderElem> res= new ArrayList<>();
        try {
            res= baker_perfil.ordersToDo(tk.getUsernameFromToken(token));
            return ResponseEntity.ok().body(res);
        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }

    }

    @RolesAllowed("ROLE_BAKER")
    @CrossOrigin
    @GetMapping("/orders/done")
    public ResponseEntity getOrdersDone(@RequestHeader String Authorization){
        String token = Authorization.substring(7);
        ArrayList<OrderElem> res= new ArrayList<>();
        try {
            res= baker_perfil.ordersDone(tk.getUsernameFromToken(token));
            return ResponseEntity.ok().body(res);
        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }

    }
}

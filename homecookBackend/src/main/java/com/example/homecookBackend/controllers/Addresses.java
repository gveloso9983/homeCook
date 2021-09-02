package com.example.homecookBackend.controllers;

import com.example.homecookBackend.beans.cliente_perfil;
import com.example.homecookBackend.classes.client.Client;
import com.example.homecookBackend.config.TokenProvider;
import com.example.homecookBackend.responses.AddressElem;
import com.example.homecookBackend.responses.IdElem;
import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.homecookBackend.classes.address.Address;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.Map;

import static java.lang.Integer.valueOf;

@RestController
@RequestMapping("/address")
public class Addresses {
    @Autowired
    private TokenProvider tk;

    @RolesAllowed("ROLE_USER")
    @CrossOrigin
    @PostMapping("/")
    public ResponseEntity addressesInfo(@RequestHeader String Authorization,@RequestBody Map<String,Object> body) {
        String token = Authorization.substring(7);

        String postalCode = (String) body.get("postalCode");
        String street = (String) body.get("street");
        String city = (String) body.get("city");

        if (postalCode == null || postalCode.length() == 0) {
            return ResponseEntity.badRequest().body("Codigo postal inválido");
        }

        if (street == null || street.length() == 0) {
            return ResponseEntity.badRequest().body("Morada inválida");
        }

        if (city == null || city.length() == 0) {
            return ResponseEntity.badRequest().body("Localidade inválida");
        }

        try {
            int id = cliente_perfil.addAddress(tk.getUsernameFromToken(token), street, postalCode, city);
            return ResponseEntity.ok().body(new IdElem(id));
        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @RolesAllowed("ROLE_USER")
    @CrossOrigin
    @PutMapping("/{address_id}")
    public ResponseEntity addressMod(@RequestHeader String Authorization,@RequestBody Map<String,Object> body,@PathVariable Integer address_id) {
        String token = Authorization.substring(7);

        String postalCode = (String) body.get("postalCode");
        String street = (String) body.get("street");
        String city = (String) body.get("city");

        if (postalCode == null || postalCode.length() == 0) {
            return ResponseEntity.badRequest().body("Codigo postal inválido");
        }

        if (street == null || street.length() == 0) {
            return ResponseEntity.badRequest().body("Morada inválida");
        }

        if (city == null || city.length() == 0) {
            return ResponseEntity.badRequest().body("Localidade inválida");
        }

        try {
            int id = cliente_perfil.updateAddress(tk.getUsernameFromToken(token),address_id, street, postalCode, city);
            return ResponseEntity.ok().body(new IdElem(id));
        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @RolesAllowed("ROLE_USER")
    @CrossOrigin
    @GetMapping("/list")
    public ResponseEntity addressesList(@RequestHeader String Authorization){
        String token = Authorization.substring(7);

        try {
            ArrayList<AddressElem> res = cliente_perfil.listAddress(tk.getUsernameFromToken(token));
            return ResponseEntity.ok().body(res);
        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }

    }

    @RolesAllowed("ROLE_USER")
    @CrossOrigin
    @GetMapping("/{address_id}")
    public ResponseEntity addressInfo(@RequestHeader String Authorization, @PathVariable Integer address_id){
        String token = Authorization.substring(7);
        try {
            AddressElem res = cliente_perfil.getAddress(tk.getUsernameFromToken(token),address_id);
            return ResponseEntity.ok().body(res);
        } catch (PersistentException | IllegalAccessException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }

    }

    @RolesAllowed("ROLE_USER")
    @CrossOrigin
    @DeleteMapping("/{address_id}")
    public ResponseEntity addressDelete(@RequestHeader String Authorization, @PathVariable Integer address_id){
        String token = Authorization.substring(7);
        try {
            cliente_perfil.deleteAddress(tk.getUsernameFromToken(token),address_id);
            return ResponseEntity.ok().body("Morada apagada com sucesso");
        } catch (IllegalAccessException | PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }

    }

}

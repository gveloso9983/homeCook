package com.example.homecookBackend.controllers;

import com.example.homecookBackend.beans.category_perfil;
import com.example.homecookBackend.classes.category.Category;
import org.orm.PersistentException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class Categories {
    @GetMapping("/list")
    public ResponseEntity list(){
        try {
            Category[] res = category_perfil.list();
            return ResponseEntity.ok().body(res);
        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().body("Não foi possível processar o pedido");
        }
    }
}

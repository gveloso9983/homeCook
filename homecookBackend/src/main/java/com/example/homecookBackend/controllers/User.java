package com.example.homecookBackend.controllers;

import com.example.homecookBackend.beans.user_perfil;
import com.example.homecookBackend.classes.MyUser;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class User {
    @CrossOrigin
    @GetMapping("currentUsername")
    public ResponseEntity currentUserName(Authentication authentication) {
        String email= authentication.getName();
        String authority = authentication.getAuthorities().toString();
        MyUser current = new MyUser();

        try {
            if (authority.equals("[ROLE_CLIENT]")){
                current = user_perfil.currentClient(email);
            }else if (authority.equals("[ROLE_BAKER]")){
                current = user_perfil.currentBaker(email);
            }
            return ResponseEntity.ok(current);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Utilizador não encontrado");

        }
    }
}

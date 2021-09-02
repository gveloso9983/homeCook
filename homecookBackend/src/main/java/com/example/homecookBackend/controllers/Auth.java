package com.example.homecookBackend.controllers;

import com.example.homecookBackend.beans.baker_perfil;
import com.example.homecookBackend.beans.cliente_perfil;
import com.example.homecookBackend.beans.user_perfil;
import com.example.homecookBackend.classes.AuthToken;
import com.example.homecookBackend.classes.MyUser;
import com.example.homecookBackend.config.TokenProvider;
import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class Auth {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Map<String,Object> body){
        try {
            String firstName = (String) body.get("firstName");
            String lastName = (String) body.get("lastName");
            String phoneNumber = (String) body.get("phoneNumber");
            String email = (String) body.get("email");
            String tipo = (String) body.get("category");
            String birth = (String) body.get("birth");
            String password = (String) body.get("password");
            if(firstName==null || firstName.length()==0){
                return ResponseEntity.badRequest().body("Primeiro nome não preenchido");
            }
            if(lastName==null || lastName.length()==0){
                return ResponseEntity.badRequest().body("ùltimo nome não preenchido");
            }
            if(phoneNumber==null || phoneNumber.length()==0){
                return ResponseEntity.badRequest().body("Número de telemovél nome não preenchido");
            }
            if(email==null || email.length()==0){
                return ResponseEntity.badRequest().body("Email não preenchido");
            }

            if(password==null || password.length()==0){
                return ResponseEntity.badRequest().body("Password não preenchida");
            }

            if(tipo==null || tipo.length()==0 || !(tipo.toLowerCase().equals("pasteleiro") || tipo.toLowerCase().equals("comprador"))){
                return ResponseEntity.badRequest().body("Tipo não preenchido ou preenchido com um valor não aceite");
            }

            if(birth==null || birth.length()==0){
                return ResponseEntity.badRequest().body("Data de nascimento não preenchida não preenchido");
            }


            Date date=new SimpleDateFormat("yyyy-MM-dd").parse(birth);

            long gap = ChronoUnit.YEARS.between(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),LocalDate.now());
            //Period period = Period.between( date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());

            if(gap < 18){
                return ResponseEntity.badRequest().body("O utilizador não tem a idade mínima obrigatória");
            }
            if(user_perfil.email_in_use(email)){
                return ResponseEntity.badRequest().body("Email já em uso");
            }

            String encodedpass =new BCryptPasswordEncoder(11).encode(password);

            if(tipo.toLowerCase().equals("pasteleiro") ) {
                baker_perfil.register(firstName, lastName, email, phoneNumber, encodedpass,date);
            }else {
                cliente_perfil.register(firstName, lastName, email, phoneNumber, encodedpass,date);
            }

            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            final String token = jwtTokenUtil.generateToken(authentication);
            return ResponseEntity.ok(new AuthToken(token));

        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().body("Não foi possivél processar o pedido em questão");
        } catch (ParseException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().body("A data de nascimento inserida não se encontra no formato correto");
        }

    }

    @CrossOrigin
    @PutMapping("/editRegister")
    public ResponseEntity editRegister(@RequestBody Map<String,Object> body){
        try {
            String firstName = (String) body.get("firstName");
            String lastName = (String) body.get("lastName");
            String phoneNumber = (String) body.get("phoneNumber");
            //String email = (String) body.get("email");
            String tipo = (String) body.get("category");
            String birth = (String) body.get("birth");
            int userId = (int) body.get("userId");

            if(firstName==null || firstName.length()==0){
                return ResponseEntity.badRequest().body("Primeiro nome não preenchido");
            }
            if(lastName==null || lastName.length()==0){
                return ResponseEntity.badRequest().body("ùltimo nome não preenchido");
            }
            if(phoneNumber==null || phoneNumber.length()==0){
                return ResponseEntity.badRequest().body("Número de telemovél nome não preenchido");
            }
            /*if(email==null || email.length()==0){
                return ResponseEntity.badRequest().body("Email não preenchido");
            }*/

            if(tipo==null || tipo.length()==0 || !(tipo.toLowerCase().equals("pasteleiro") || tipo.toLowerCase().equals("comprador"))){
                return ResponseEntity.badRequest().body("Tipo não preenchido ou preenchido com um valor não aceite");
            }

            if(birth==null || birth.length()==0){
                return ResponseEntity.badRequest().body("Data de nascimento não preenchida não preenchido");
            }


            Date date=new SimpleDateFormat("yyyy-MM-dd").parse(birth);

            long gap = ChronoUnit.YEARS.between( date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),LocalDate.now());

            //Period period = Period.between( date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());

            if(gap < 18){
                return ResponseEntity.badRequest().body("O utilizador não tem a idade mínima obrigatória");
            }
            /*if(user_perfil.email_in_use(email)){
                return ResponseEntity.badRequest().body("Email já em uso");
            }*/

            if(tipo.toLowerCase().equals("pasteleiro") ) {
                baker_perfil.editRegister(userId, firstName, lastName, phoneNumber,date);
            }else {
                cliente_perfil.editRegister(userId, firstName, lastName, phoneNumber,date);
            }

            return ResponseEntity.ok().body("Operação efetuada com sucesso");

        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().body("Não foi possivel processar o pedido em questão");
        } catch (ParseException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().body("A data de nascimento inserida não se encontra no formato correto");
        }
    }

    @CrossOrigin
    @PostMapping("/editPassword")
    public ResponseEntity editPassword(@RequestBody Map<String,Object> body){
        try {

            String tipo = (String) body.get("category");
            String password = (String) body.get("password");
            int userId = (int) body.get("userId");


            if(password==null || password.length()==0){
                return ResponseEntity.badRequest().body("Password não preenchida");
            }

            if(tipo==null || tipo.length()==0 || !(tipo.toLowerCase().equals("pasteleiro") || tipo.toLowerCase().equals("comprador"))){
                return ResponseEntity.badRequest().body("Tipo não preenchido ou preenchido com um valor não aceite");
            }


            String encodedpass =new BCryptPasswordEncoder(11).encode(password);

            if(tipo.toLowerCase().equals("pasteleiro") ) {
                baker_perfil.editPassword(encodedpass, userId);
            }else {
                cliente_perfil.editPassword(encodedpass, userId);
            }

            return ResponseEntity.ok().body("Operação efetuada com sucesso");

        } catch (PersistentException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().body("Não foi possivél processar o pedido em questão");
        }

    }


    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Map<String,Object> body){
        String email = (String) body.get("email");
        String password = (String) body.get("password");

        try {
            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            final String token = jwtTokenUtil.generateToken(authentication);
            return ResponseEntity.ok(new AuthToken(token));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Credenciais erradas");

        }
    }



}

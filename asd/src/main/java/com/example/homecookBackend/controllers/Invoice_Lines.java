package com.example.homecookBackend.controllers;


import com.example.homecookBackend.beans.baker_perfil;
import com.example.homecookBackend.config.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Map;

@RestController
@RequestMapping("/invoice_lines")
public class Invoice_Lines {

    @Autowired
    private TokenProvider tk;

    @RolesAllowed("ROLE_BAKER")
    @CrossOrigin
    @PostMapping("/{line_id}/state")
    public ResponseEntity getLine(@RequestHeader String Authorization, @PathVariable Integer line_id, @RequestBody Map<String,Object> body ){
        Boolean done = Boolean.parseBoolean((String) body.get("done"));
        String token = Authorization.substring(7);

        if(done==null){
            return ResponseEntity.badRequest().body("Valor Inválido");
        }

        try {

            baker_perfil.changeInvoice_lineStatus(tk.getUsernameFromToken(token), line_id, done);
            return ResponseEntity.ok().body("Mudado com sucesso");

        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body("Produto não encontrado");

        }
    }
}

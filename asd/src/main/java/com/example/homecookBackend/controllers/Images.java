package com.example.homecookBackend.controllers;

import com.example.homecookBackend.classes.ReturnImg;
import com.example.homecookBackend.classes.image.Image;
import com.example.homecookBackend.classes.image.ImageDAO;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.orm.PersistentException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.*;
import java.net.MalformedURLException;

@RestController
@RequestMapping("/images")
public class Images {
    @CrossOrigin
    @GetMapping (value = "/{imageid}",produces = "image/*")
    public byte[] getimage(@PathVariable Integer imageid) throws PersistentException, IOException {

            ResponseEntity respEntity = null;
            Image i = ImageDAO.getImageByORMID(imageid);

            String[] parts = i.getPath().split("/");
            String name = parts[parts.length-1];
            File result =new File(i.getPath());

            if(result.exists()){
                InputStream inputStream = new FileInputStream(i.getPath());
                String type=result.toURL().openConnection().guessContentTypeFromName(name);

                byte[]out = inputStream.readAllBytes();
                inputStream.close();

                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.add("content-disposition", "attachment; filename=" + name);
                responseHeaders.add("Content-Type",type);

                 return out;

            }

            return new byte[1];

    }
    @CrossOrigin
    @GetMapping (value = "/class/{imageid}")
    public ResponseEntity getimageClasse(@PathVariable Integer imageid) throws PersistentException, IOException {

        ResponseEntity respEntity = null;
        Image i = ImageDAO.getImageByORMID(imageid);
        String[] parts = i.getPath().split("/");
        String name = parts[parts.length-1];
        File result =new File(i.getPath());

        if(result.exists()){

            InputStream inputStream = new FileInputStream(i.getPath());
            String type=result.toURL().openConnection().guessContentTypeFromName(name);
            int out = inputStream.readAllBytes().length;
            inputStream.close();
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("content-disposition", "attachment; filename=" + name);
            responseHeaders.add("Content-Type",type);

            ReturnImg returnImg = new ReturnImg(name, type, out, i.getPath()) ;
            return ResponseEntity.ok().body(returnImg);
        }else{
            return ResponseEntity.badRequest().body("Erro Interno");
        }
    }
    
}

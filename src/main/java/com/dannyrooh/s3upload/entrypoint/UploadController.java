package com.dannyrooh.s3upload.entrypoint;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping(value = "/api/upload", produces= {"application/json"})
@Slf4j
@CrossOrigin("*")
public class UploadController {
    

    private final String pathArquivo;

     public UploadController(@Value("${app.path.arquivos}") String pathArquivo){
        
        this.pathArquivo = pathArquivo;

     }


    @PostMapping("/arquivo")
    public ResponseEntity<String> salvarArquivo(@RequestParam("file") MultipartFile file) {
         log.info("Recebendo o arquvo: " + file.getOriginalFilename());

         
         var caminho = pathArquivo + UUID.randomUUID() + "." + extrairExtensao(file.getOriginalFilename());
        
         log.info("Novo nome do arquivo " + caminho);

         try {

            Files.copy(file.getInputStream(), Path.of(caminho), StandardCopyOption.REPLACE_EXISTING);

            return new ResponseEntity<>("{\"mensagem\":\"Arquivo carregado com sucesso!\"}", HttpStatus.OK);
            
         } catch (Exception e) {

            log.error("Erro ao processar o arquivo", e);

            return new ResponseEntity<>("{\"mensagem\":\"Erro ao carregar o arquivo!\"}", HttpStatus.OK);
            
         }
    }

    private String extrairExtensao(String originalFilename) {
        
        int i = originalFilename.lastIndexOf(".") + 1;
        return originalFilename.substring(i);
        
    }
    
    
}

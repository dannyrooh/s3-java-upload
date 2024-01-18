package com.dannyrooh.s3upload.documento.domain.mapper;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.dannyrooh.s3upload.documento.domain.dto.UploadDocumentoStreamDTO;
import com.dannyrooh.s3upload.util.UtilCheckSum256;


@Component
public class UploadDocumentoStreamDTOMapper {


    public UploadDocumentoStreamDTO toDTO(MultipartFile file) throws NoSuchAlgorithmException, IOException{
        
        var response = new UploadDocumentoStreamDTO();

        response.setFile(file.getInputStream());
        response.setCheckSum(UtilCheckSum256.exec(file.getInputStream()));
        
        var name = file.getOriginalFilename();
        response.setNome(extractFileNameWithoutExtension(name));
        response.setExtensao(extrairExtensao(name));
        response.setNomeS3(generateName(response.getExtensao()));

        return response;
    }

    private String extrairExtensao(String originalFilename) {
        
        int i = originalFilename.lastIndexOf(".") + 1;

        return originalFilename.substring(i);
        
    }

    private String extractFileNameWithoutExtension(String originalFilename) {

        int lastDotIndex = originalFilename.lastIndexOf(".");

        if (lastDotIndex > 0) {
            return originalFilename.substring(0, lastDotIndex);
        } else {
            return originalFilename; 
        }
    }    

    private String generateName(String extensao){

        return UUID.randomUUID() + "." + extensao;

    }
    
}

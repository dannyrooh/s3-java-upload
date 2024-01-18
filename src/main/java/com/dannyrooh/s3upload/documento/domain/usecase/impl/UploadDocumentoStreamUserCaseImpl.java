package com.dannyrooh.s3upload.documento.domain.usecase.impl;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.dannyrooh.s3upload.documento.domain.dto.UploadDocumentoStreamDTO;
import com.dannyrooh.s3upload.documento.domain.entity.DocumentoUpload;
import com.dannyrooh.s3upload.documento.domain.gateway.DocumentoUploadGateway;
import com.dannyrooh.s3upload.documento.domain.mapper.UploadDocumentoStreamDTOMapper;
import com.dannyrooh.s3upload.documento.domain.usecase.UploadDocumentoStreamUseCase;
import com.dannyrooh.s3upload.documento.domain.usecase.response.UploadDocumentoResponse;
import com.dannyrooh.s3upload.documento.domain.usecase.response.mapper.UploadDocumentoResponseMapper;

@Component
public class UploadDocumentoStreamUserCaseImpl implements UploadDocumentoStreamUseCase   {

    private final DocumentoUploadGateway gateway;
    private final UploadDocumentoStreamDTOMapper uploadDocumentoStreamDTOMapper;

    public UploadDocumentoStreamUserCaseImpl( 
        final DocumentoUploadGateway gateway,
        final UploadDocumentoStreamDTOMapper uploadDocumentoStreamDTOMapper){

        this.gateway = gateway;
        this.uploadDocumentoStreamDTOMapper = uploadDocumentoStreamDTOMapper;
    }

    @Override
    public UploadDocumentoResponse upload(MultipartFile request) {
     
        if (request.isEmpty()) {
            throw new IllegalArgumentException("O arquivo está vazio. Por favor, forneça um arquivo válido.");
        }

        //Verifica se o caminho do arquivo contém um diretório (proteção contra ataques de Path Traversal).
        if (request.getOriginalFilename() != null && request.getOriginalFilename().contains("/")) {
            throw new IllegalArgumentException("O caminho do arquivo contém um diretório. Por favor, forneça um arquivo válido.");
        }

        UploadDocumentoStreamDTO dto;
        DocumentoUpload entity;
        UploadDocumentoResponse response;

        try {
            dto = this.uploadDocumentoStreamDTOMapper.toDTO(request);
            entity = this.gateway.sendStream(dto);
            response =  UploadDocumentoResponseMapper.INSTANCE.toResponse(entity);
            return response;
            
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    
}

package com.dannyrooh.s3upload.documento.infra.mapper;

import org.springframework.stereotype.Component;

import com.dannyrooh.s3upload.documento.domain.dto.UploadDocumentoStreamDTO;
import com.dannyrooh.s3upload.documento.domain.entity.DocumentoUpload;

@Component
public class DocumentoUploadMapper {

    public DocumentoUpload toEntity(UploadDocumentoStreamDTO dto) {
        var entity = new DocumentoUpload();
        entity.setCaminho(dto.getNomeS3());
        entity.setChecksum(dto.getCheckSum());
        entity.setExtensao(dto.getExtensao());
        entity.setNome(dto.getNome());

        return entity;
    }
    
}

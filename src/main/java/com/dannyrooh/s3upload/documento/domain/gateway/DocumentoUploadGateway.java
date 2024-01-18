package com.dannyrooh.s3upload.documento.domain.gateway;


import com.dannyrooh.s3upload.documento.domain.dto.UploadDocumentoStreamDTO;
import com.dannyrooh.s3upload.documento.domain.entity.DocumentoUpload;

public interface DocumentoUploadGateway {

    public DocumentoUpload sendStream(UploadDocumentoStreamDTO dto);
    
}

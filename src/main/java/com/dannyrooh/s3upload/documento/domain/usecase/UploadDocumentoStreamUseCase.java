package com.dannyrooh.s3upload.documento.domain.usecase;

import org.springframework.web.multipart.MultipartFile;

import com.dannyrooh.s3upload.documento.domain.usecase.response.UploadDocumentoResponse;

public interface UploadDocumentoStreamUseCase {

    UploadDocumentoResponse upload(MultipartFile request);
    
}

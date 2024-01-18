package com.dannyrooh.s3upload.documento.infra.dataprovider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.dannyrooh.s3upload.documento.domain.dto.UploadDocumentoStreamDTO;
import com.dannyrooh.s3upload.documento.domain.entity.DocumentoUpload;
import com.dannyrooh.s3upload.documento.domain.gateway.DocumentoUploadGateway;
import com.dannyrooh.s3upload.documento.infra.mapper.DocumentoUploadMapper;
import com.dannyrooh.s3upload.documento.infra.storage.AmazonS3Repository;

@Component 
public class DocumentoUploadProvider implements DocumentoUploadGateway {

    private final AmazonS3Repository amazonS3Repository;
    private final String bucketPath;
    private final DocumentoUploadMapper mapper;

    public DocumentoUploadProvider(
        final AmazonS3Repository amazonS3Repository,
        final DocumentoUploadMapper documentoUploadMapper,
        @Value("${app.s3.bucket_path}") String bucketPath){

        this.amazonS3Repository = amazonS3Repository;

        this.mapper = documentoUploadMapper;

        this.bucketPath = ensureTrailingSlash(bucketPath);
    }

    @Override
    public DocumentoUpload sendStream( UploadDocumentoStreamDTO dto) {

        dto.setNomeS3(this.bucketPath + dto.getNomeS3());

        amazonS3Repository.sendStream(dto.getNomeS3() ,dto.getFile());

        return mapper.toEntity(dto);
    }

    private String ensureTrailingSlash(String value) {

        if (value == null || value.trim().isEmpty()) {
            return ""; 
        }

        return  value + ( value.endsWith("/") ?  "" : "/" );
    }
}

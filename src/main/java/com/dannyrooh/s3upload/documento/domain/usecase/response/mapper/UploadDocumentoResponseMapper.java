package com.dannyrooh.s3upload.documento.domain.usecase.response.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dannyrooh.s3upload.documento.domain.entity.DocumentoUpload;
import com.dannyrooh.s3upload.documento.domain.usecase.response.UploadDocumentoResponse;

@Mapper(componentModel = "spring")
public interface UploadDocumentoResponseMapper {   

     UploadDocumentoResponseMapper INSTANCE = Mappers.getMapper(UploadDocumentoResponseMapper.class);
 
     UploadDocumentoResponse toResponse(DocumentoUpload entity);
}

package com.dannyrooh.s3upload.documento.domain.usecase.response.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dannyrooh.s3upload.documento.domain.entity.Documento;
import com.dannyrooh.s3upload.documento.domain.usecase.response.AtualizaDocumentoResponse;

@Mapper(componentModel = "spring")
public interface AtualizaDocumentoResponseMapper {

    AtualizaDocumentoResponseMapper INSTANCE = Mappers.getMapper( AtualizaDocumentoResponseMapper.class );

    AtualizaDocumentoResponse toResponse(Documento entity);

}


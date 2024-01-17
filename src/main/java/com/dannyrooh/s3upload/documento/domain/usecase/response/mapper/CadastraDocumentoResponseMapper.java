package com.dannyrooh.s3upload.documento.domain.usecase.response.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dannyrooh.s3upload.documento.domain.entity.Documento;
import com.dannyrooh.s3upload.documento.domain.usecase.response.CadastraDocumentoResponse;

@Mapper(componentModel = "spring")
public interface CadastraDocumentoResponseMapper {

    CadastraDocumentoResponseMapper INSTANCE = Mappers.getMapper(CadastraDocumentoResponseMapper.class);

    CadastraDocumentoResponse toResponse(Documento entity);

}

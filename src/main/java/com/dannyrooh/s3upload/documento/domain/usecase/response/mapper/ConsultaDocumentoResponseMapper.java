package com.dannyrooh.s3upload.documento.domain.usecase.response.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dannyrooh.s3upload.documento.domain.entity.Documento;
import com.dannyrooh.s3upload.documento.domain.usecase.response.ConsultaDocumentoResponse;

@Mapper(componentModel = "spring")
public interface ConsultaDocumentoResponseMapper {

    ConsultaDocumentoResponseMapper INSTANCE = Mappers.getMapper(ConsultaDocumentoResponseMapper.class);

    List<ConsultaDocumentoResponse> toResponseList(List<Documento> entity);

    ConsultaDocumentoResponse toResponse(Documento entity);

}

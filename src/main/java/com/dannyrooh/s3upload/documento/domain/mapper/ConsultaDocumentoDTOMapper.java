package com.dannyrooh.s3upload.documento.domain.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dannyrooh.s3upload.documento.domain.dto.ConsultaDocumentoDTO;
import com.dannyrooh.s3upload.documento.domain.usecase.request.ConsultaDocumentoRequest;

@Mapper(componentModel = "spring")
public interface ConsultaDocumentoDTOMapper {

    ConsultaDocumentoDTOMapper INSTANCE = Mappers.getMapper(ConsultaDocumentoDTOMapper.class);

    ConsultaDocumentoDTO toDTO(ConsultaDocumentoRequest request);

    List<ConsultaDocumentoDTO> toDTOList(List<ConsultaDocumentoRequest> request);

}

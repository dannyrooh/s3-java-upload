package com.dannyrooh.s3upload.documento.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dannyrooh.s3upload.documento.domain.dto.AtualizaDocumentoDTO;
import com.dannyrooh.s3upload.documento.domain.usecase.request.AtualizaDocumentoRequest;




@Mapper(componentModel = "spring")
public interface AtualizaDocumentoDTOMapper{

    AtualizaDocumentoDTOMapper INSTANCE = Mappers.getMapper( AtualizaDocumentoDTOMapper.class );

    AtualizaDocumentoDTO toDTO(AtualizaDocumentoRequest request);

}

package com.dannyrooh.s3upload.documento.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dannyrooh.s3upload.documento.domain.dto.CadastraDocumentoDTO;
import com.dannyrooh.s3upload.documento.domain.usecase.request.CadastraDocumentoRequest; 

@Mapper(componentModel = "spring")
public interface CadastraDocumentoDTOMapper{

    CadastraDocumentoDTOMapper INSTANCE = Mappers.getMapper( CadastraDocumentoDTOMapper.class );
    
    CadastraDocumentoDTO toDTO(CadastraDocumentoRequest request);

}


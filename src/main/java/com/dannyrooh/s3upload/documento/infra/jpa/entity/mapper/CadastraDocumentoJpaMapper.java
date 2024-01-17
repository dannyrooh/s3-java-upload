package com.dannyrooh.s3upload.documento.infra.jpa.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dannyrooh.s3upload.documento.domain.dto.CadastraDocumentoDTO;
import com.dannyrooh.s3upload.documento.infra.jpa.entity.DocumentoJpa;

import lombok.NonNull; 

@Mapper(componentModel = "spring")
public interface CadastraDocumentoJpaMapper {

    CadastraDocumentoJpaMapper  INSTANCE = Mappers.getMapper( CadastraDocumentoJpaMapper .class );


    DocumentoJpa toJpa(@NonNull CadastraDocumentoDTO dto);

}


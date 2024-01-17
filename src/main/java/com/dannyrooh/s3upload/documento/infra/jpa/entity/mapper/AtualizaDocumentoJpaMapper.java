package com.dannyrooh.s3upload.documento.infra.jpa.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dannyrooh.s3upload.documento.domain.dto.AtualizaDocumentoDTO;
import com.dannyrooh.s3upload.documento.infra.jpa.entity.DocumentoJpa;

import lombok.NonNull;


@Mapper(componentModel = "spring")
public interface AtualizaDocumentoJpaMapper{

    AtualizaDocumentoJpaMapper INSTANCE = Mappers.getMapper( AtualizaDocumentoJpaMapper.class );

    DocumentoJpa toJpa(@NonNull AtualizaDocumentoDTO dto);

}

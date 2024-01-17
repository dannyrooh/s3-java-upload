package com.dannyrooh.s3upload.documento.infra.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dannyrooh.s3upload.documento.domain.entity.Documento;
import com.dannyrooh.s3upload.documento.infra.jpa.entity.DocumentoJpa;

@Mapper(componentModel = "spring")
public interface DocumentoMapper {

    DocumentoMapper INSTANCE = Mappers.getMapper(DocumentoMapper.class);

    public Documento toEntity(DocumentoJpa jpa);

    List<Documento> toEntityList(List<DocumentoJpa> jpa);

}

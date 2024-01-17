
package com.dannyrooh.s3upload.documento.infra.jpa.entity.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dannyrooh.s3upload.documento.domain.dto.ConsultaDocumentoDTO;
import com.dannyrooh.s3upload.documento.infra.jpa.entity.DocumentoJpa;

@Mapper(componentModel = "spring")
public interface ConsultaDocumentoJpaMapper {

    ConsultaDocumentoJpaMapper INSTANCE = Mappers.getMapper(ConsultaDocumentoJpaMapper.class);

    DocumentoJpa toJpa(ConsultaDocumentoDTO dto);

    List<DocumentoJpa> toJpaList(List<ConsultaDocumentoDTO> dto);

}

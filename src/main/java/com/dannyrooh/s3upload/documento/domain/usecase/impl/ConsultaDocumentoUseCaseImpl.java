package com.dannyrooh.s3upload.documento.domain.usecase.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dannyrooh.s3upload.documento.domain.gateway.DocumentoGateway;
import com.dannyrooh.s3upload.documento.domain.mapper.ConsultaDocumentoDTOMapper;
import com.dannyrooh.s3upload.documento.domain.usecase.ConsultaDocumentoUseCase;
import com.dannyrooh.s3upload.documento.domain.usecase.response.ConsultaDocumentoResponse;
import com.dannyrooh.s3upload.documento.domain.usecase.response.mapper.ConsultaDocumentoResponseMapper;

@Component
public class ConsultaDocumentoUseCaseImpl implements ConsultaDocumentoUseCase {

    private final DocumentoGateway gateway;

    public ConsultaDocumentoUseCaseImpl(final DocumentoGateway gateway) {

        this.gateway = gateway;

    }

    @Override
    public List<ConsultaDocumentoResponse> buscar() {
     
        var dto = ConsultaDocumentoDTOMapper.INSTANCE.toDTO(null);

        var entityList = gateway.buscar(dto);

        return ConsultaDocumentoResponseMapper.INSTANCE.toResponseList(entityList);

    }

}

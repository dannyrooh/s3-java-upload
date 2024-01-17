package com.dannyrooh.s3upload.documento.domain.usecase.impl;

import com.dannyrooh.s3upload.documento.domain.gateway.DocumentoGateway;
import com.dannyrooh.s3upload.documento.domain.usecase.ConsultaDocumentoPorIdUseCase;
import com.dannyrooh.s3upload.documento.domain.usecase.response.ConsultaDocumentoResponse;
import com.dannyrooh.s3upload.documento.domain.usecase.response.mapper.ConsultaDocumentoResponseMapper;
import com.dannyrooh.s3upload.share.exception.NoContentException;

import org.springframework.stereotype.Component;

@Component
public class ConsultaDocumentoPorIdUseCaseImpl implements ConsultaDocumentoPorIdUseCase {

    private final DocumentoGateway gateway;

    public ConsultaDocumentoPorIdUseCaseImpl(final DocumentoGateway gateway) {

        this.gateway = gateway;

    }

    @Override
    public ConsultaDocumentoResponse buscarPor( Integer id) {
     
        var optional = gateway.buscarPor(id);

        if (optional.isPresent()) {
            return ConsultaDocumentoResponseMapper.INSTANCE.toResponse(optional.get());
        } else {
            throw new NoContentException();
        }

    }

}

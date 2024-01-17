package com.dannyrooh.s3upload.documento.domain.usecase.impl;

import com.dannyrooh.s3upload.documento.domain.gateway.DocumentoGateway;
import com.dannyrooh.s3upload.documento.domain.usecase.ExcluiDocumentoPorIdUseCase;
import com.dannyrooh.s3upload.share.exception.BusinessException;

import org.springframework.stereotype.Component;

@Component
public class ExcluiDocumentoPorIdUseCaseImpl implements ExcluiDocumentoPorIdUseCase {

    private final DocumentoGateway gateway;

    public ExcluiDocumentoPorIdUseCaseImpl(final DocumentoGateway gateway) {

        this.gateway = gateway;

    }

    @Override
    public void excluirPor(Integer id) {

        var excluido = this.gateway.excluirPor(id);
        if (!excluido) {
            throw new BusinessException();
        }
    }

}

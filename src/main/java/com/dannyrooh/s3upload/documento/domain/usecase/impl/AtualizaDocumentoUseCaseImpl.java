package com.dannyrooh.s3upload.documento.domain.usecase.impl;

import org.springframework.stereotype.Component;

import com.dannyrooh.s3upload.documento.domain.gateway.DocumentoGateway;
import com.dannyrooh.s3upload.documento.domain.mapper.AtualizaDocumentoDTOMapper;
import com.dannyrooh.s3upload.documento.domain.usecase.AtualizaDocumentoUseCase;
import com.dannyrooh.s3upload.documento.domain.usecase.request.AtualizaDocumentoRequest;
import com.dannyrooh.s3upload.documento.domain.usecase.response.AtualizaDocumentoResponse;
import com.dannyrooh.s3upload.documento.domain.usecase.response.mapper.AtualizaDocumentoResponseMapper;

@Component
public class AtualizaDocumentoUseCaseImpl implements AtualizaDocumentoUseCase {

    private final DocumentoGateway gateway;

    public AtualizaDocumentoUseCaseImpl(final DocumentoGateway gateway) {

        this.gateway = gateway;

    }

    @Override
    public AtualizaDocumentoResponse atualizar(AtualizaDocumentoRequest request) {
     
        var dto = AtualizaDocumentoDTOMapper.INSTANCE.toDTO(request);

        var entity = gateway.atualizar(dto);

        return AtualizaDocumentoResponseMapper.INSTANCE.toResponse(entity);

    }

}

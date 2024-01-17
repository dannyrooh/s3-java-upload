package com.dannyrooh.s3upload.documento.domain.usecase.impl;

import org.springframework.stereotype.Component;

import com.dannyrooh.s3upload.documento.domain.gateway.DocumentoGateway;
import com.dannyrooh.s3upload.documento.domain.mapper.CadastraDocumentoDTOMapper;
import com.dannyrooh.s3upload.documento.domain.usecase.CadastraDocumentoUseCase;
import com.dannyrooh.s3upload.documento.domain.usecase.request.CadastraDocumentoRequest;
import com.dannyrooh.s3upload.documento.domain.usecase.response.CadastraDocumentoResponse;
import com.dannyrooh.s3upload.documento.domain.usecase.response.mapper.CadastraDocumentoResponseMapper;

@Component
public class CadastraDocumentoUseCaseImpl implements CadastraDocumentoUseCase {

    private final DocumentoGateway gateway;

    public CadastraDocumentoUseCaseImpl(final DocumentoGateway gateway) {

        this.gateway = gateway;
        
    }

    @Override
    public CadastraDocumentoResponse cadastrar(CadastraDocumentoRequest request) {
     
        var dto = CadastraDocumentoDTOMapper.INSTANCE.toDTO(request);

        var entity = gateway.salvar(dto);

        return CadastraDocumentoResponseMapper.INSTANCE.toResponse(entity);
        
    }

}

package com.dannyrooh.s3upload.documento.domain.usecase;

import java.util.List;

import com.dannyrooh.s3upload.documento.domain.usecase.response.ConsultaDocumentoResponse;

public interface ConsultaDocumentoUseCase {

    List<ConsultaDocumentoResponse> buscar();

}


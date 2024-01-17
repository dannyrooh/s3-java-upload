package com.dannyrooh.s3upload.documento.domain.usecase;

import com.dannyrooh.s3upload.documento.domain.usecase.request.CadastraDocumentoRequest;
import com.dannyrooh.s3upload.documento.domain.usecase.response.CadastraDocumentoResponse;

public interface CadastraDocumentoUseCase {

    CadastraDocumentoResponse cadastrar(CadastraDocumentoRequest request);

}
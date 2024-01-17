package com.dannyrooh.s3upload.documento.domain.usecase;

import com.dannyrooh.s3upload.documento.domain.usecase.request.AtualizaDocumentoRequest;
import com.dannyrooh.s3upload.documento.domain.usecase.response.AtualizaDocumentoResponse;

public interface AtualizaDocumentoUseCase {

    AtualizaDocumentoResponse atualizar(AtualizaDocumentoRequest request);

}
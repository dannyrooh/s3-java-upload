package com.dannyrooh.s3upload.documento.domain.usecase;

import com.dannyrooh.s3upload.documento.domain.usecase.response.ConsultaDocumentoResponse;

public interface ConsultaDocumentoPorIdUseCase  {

    ConsultaDocumentoResponse buscarPor(Integer id);

}
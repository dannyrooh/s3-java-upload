package com.dannyrooh.s3upload.documento.domain.gateway;

import java.util.List;
import java.util.Optional;

import com.dannyrooh.s3upload.documento.domain.dto.AtualizaDocumentoDTO;
import com.dannyrooh.s3upload.documento.domain.dto.CadastraDocumentoDTO;
import com.dannyrooh.s3upload.documento.domain.dto.ConsultaDocumentoDTO;
import com.dannyrooh.s3upload.documento.domain.entity.Documento;

import lombok.NonNull;

public interface DocumentoGateway {
    
	Documento atualizar(@NonNull AtualizaDocumentoDTO dto);

	Documento salvar(@NonNull CadastraDocumentoDTO dto);

	List<Documento> buscar(ConsultaDocumentoDTO dto);

	Optional<Documento> buscarPor(Integer id);

	boolean excluirPor(Integer id);    

}
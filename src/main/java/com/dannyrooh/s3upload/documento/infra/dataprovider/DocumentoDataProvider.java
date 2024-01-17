package com.dannyrooh.s3upload.documento.infra.dataprovider;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.dannyrooh.s3upload.documento.domain.dto.AtualizaDocumentoDTO;
import com.dannyrooh.s3upload.documento.domain.dto.CadastraDocumentoDTO;
import com.dannyrooh.s3upload.documento.domain.dto.ConsultaDocumentoDTO;
import com.dannyrooh.s3upload.documento.domain.entity.Documento;
import com.dannyrooh.s3upload.documento.domain.gateway.DocumentoGateway;
import com.dannyrooh.s3upload.documento.infra.jpa.entity.mapper.AtualizaDocumentoJpaMapper;
import com.dannyrooh.s3upload.documento.infra.jpa.entity.mapper.CadastraDocumentoJpaMapper;
import com.dannyrooh.s3upload.documento.infra.jpa.repository.DocumentoRepository;
import com.dannyrooh.s3upload.documento.infra.mapper.DocumentoMapper;

import lombok.NonNull;

@Component
class DocumentoDataProvider implements DocumentoGateway {

    private final DocumentoRepository repository;

    public DocumentoDataProvider(DocumentoRepository repository){
        this.repository = repository;
    }
    
    @Override
	public Documento salvar(@NonNull CadastraDocumentoDTO dto){

        var jpa = CadastraDocumentoJpaMapper.INSTANCE.toJpa(dto);

        var model = repository.save(jpa);

        return DocumentoMapper.INSTANCE.toEntity(model);  

    }

    @Override
	public List<Documento> buscar(ConsultaDocumentoDTO dto){

        var lista = repository.findAll();

        return DocumentoMapper.INSTANCE.toEntityList(lista); 

    }

    @Override
	public Optional<Documento> buscarPor(@NonNull Integer id){

        var optional = repository.findById(id);

		if (optional.isPresent()) {
			return Optional.ofNullable(DocumentoMapper.INSTANCE.toEntity(optional.get()));
		} else {
			return Optional.empty();
		}
    }

    @Override
	public Documento atualizar(@NonNull AtualizaDocumentoDTO dto){

        var jpa = AtualizaDocumentoJpaMapper.INSTANCE.toJpa(dto);

        var model = repository.save(jpa);    

        return DocumentoMapper.INSTANCE.toEntity(model);  

    }

    @Override   
	public boolean excluirPor(@NonNull Integer id){

        repository.deleteById(id);

        var optional = repository.findById(id);

        return optional.isEmpty();        

    }    

}
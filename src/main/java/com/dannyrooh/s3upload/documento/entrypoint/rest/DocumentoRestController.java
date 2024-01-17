package com.dannyrooh.s3upload.documento.entrypoint.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dannyrooh.s3upload.documento.domain.usecase.AtualizaDocumentoUseCase;
import com.dannyrooh.s3upload.documento.domain.usecase.CadastraDocumentoUseCase;
import com.dannyrooh.s3upload.documento.domain.usecase.ConsultaDocumentoPorIdUseCase;
import com.dannyrooh.s3upload.documento.domain.usecase.ConsultaDocumentoUseCase;
import com.dannyrooh.s3upload.documento.domain.usecase.ExcluiDocumentoPorIdUseCase;
import com.dannyrooh.s3upload.documento.domain.usecase.request.AtualizaDocumentoRequest;
import com.dannyrooh.s3upload.documento.domain.usecase.request.CadastraDocumentoRequest;
import com.dannyrooh.s3upload.documento.domain.usecase.response.CadastraDocumentoResponse;
import com.dannyrooh.s3upload.documento.domain.usecase.response.ConsultaDocumentoResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/documento", produces = {"application/json"})
@Tag(name = "documento")
public class DocumentoRestController {

    private final CadastraDocumentoUseCase usecase_cadastra;
    private final AtualizaDocumentoUseCase usecase_atualiza;
    private final ConsultaDocumentoUseCase usecase_busca;
    private final ConsultaDocumentoPorIdUseCase usecase_buscaporid;
    private final ExcluiDocumentoPorIdUseCase usecase_delete;

    public DocumentoRestController(final CadastraDocumentoUseCase usecase_cadastra,
                              final AtualizaDocumentoUseCase usecase_atualiza,
                              final ConsultaDocumentoUseCase usecase_busca,
                              final ConsultaDocumentoPorIdUseCase usecase_buscaporid,
                              final ExcluiDocumentoPorIdUseCase usecase_delete) {
        this.usecase_cadastra = usecase_cadastra;
        this.usecase_atualiza = usecase_atualiza;
        this.usecase_busca = usecase_busca;
        this.usecase_buscaporid = usecase_buscaporid;
        this.usecase_delete = usecase_delete;
    }

    @Operation(summary = "Cadastro de documento", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Documento cadastrado com sucesso", content = {
			    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CadastraDocumentoResponse.class)) }),
			@ApiResponse(responseCode = "422", description = "Erro de negócio ao cadastrar o documento", content = @Content) })    
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> cadastrar(@Valid @RequestBody final CadastraDocumentoRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(usecase_cadastra.cadastrar(request));

    }

    @Operation(summary = "Altera o documento", method = "PUT")
	@ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Documento atualizado com sucesso", content = @Content),
        @ApiResponse(responseCode = "422", description = "Erro de negócio ao cadastrar o documento", content = @Content) }) 
    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> atualizar(@Valid @RequestBody final AtualizaDocumentoRequest request) {

        return ResponseEntity.ok(usecase_atualiza.atualizar(request));

    }

    @Operation(summary = "Retorna todos os documentos cadastrados", method = "GET")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Todos documentos encontrados", content = {
        @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(allOf = ConsultaDocumentoResponse.class)) }),
        @ApiResponse(responseCode = "204", description = "Nenhum documento cadastrado no banco", content = @Content) })        
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> buscar() {

        return ResponseEntity.ok(usecase_busca.buscar());

    }


    @Operation(summary = "Busca um documento cadastrado pelo seu ID", method = "GET")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Documento encontrado", content = {
        @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ConsultaDocumentoResponse.class)) }),
        @ApiResponse(responseCode = "204", description = "Documento não encontrado", content = @Content) })     
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> buscarPor(@PathVariable Integer id) {

        return ResponseEntity.ok(usecase_buscaporid.buscarPor(id));

    }

    @Operation(summary = "Exclui o documento pelo seu ID", method = "DEL")
	@ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Documento excluído", content = @Content),
        @ApiResponse(responseCode = "422", description = "Erro de negócio ao excluir o docoumento", content = @Content) })       
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> excluirPor(@PathVariable Integer id) {

        usecase_delete.excluirPor(id);
        return ResponseEntity.noContent().build();

    }
}
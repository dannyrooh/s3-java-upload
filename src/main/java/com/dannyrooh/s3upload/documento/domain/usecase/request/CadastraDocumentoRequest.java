package com.dannyrooh.s3upload.documento.domain.usecase.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CadastraDocumentoRequest {


    @NotNull
    private String nome;

    private String extensao;

    @NotNull
    private String caminho;

    private String checksum;

}
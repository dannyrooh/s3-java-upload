package com.dannyrooh.s3upload.documento.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaDocumentoDTO {

    private Integer id;

    private String nome;

    private String extensao;

    private String caminho;

    private String checksum;

}
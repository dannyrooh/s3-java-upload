package com.dannyrooh.s3upload.documento.domain.dto;

import java.io.InputStream;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UploadDocumentoStreamDTO {

    private InputStream file;

    private String nomeS3;

    private String checkSum;

    private String nome;

    private String extensao;
}

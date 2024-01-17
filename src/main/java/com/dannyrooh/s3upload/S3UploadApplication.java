package com.dannyrooh.s3upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "S3 Upload de Arquivos", version = "1", description = "API desenvolvida para testes de Upload de arquivos e armazenamento em tabela de um mysql"))
public class S3UploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(S3UploadApplication.class, args);
	}

}
 
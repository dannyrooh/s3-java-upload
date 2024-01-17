package com.dannyrooh.s3upload.share.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 6993878570229158267L;

	public BusinessException() {
		super("Erro ao tentar excluir registro");
	}

	public BusinessException(String message) {
		super(message);
	}

	
}

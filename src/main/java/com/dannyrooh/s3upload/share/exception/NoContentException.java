package com.dannyrooh.s3upload.share.exception;

public class NoContentException extends RuntimeException {

	private static final long serialVersionUID = -1202371962613201083L;

	public NoContentException(String msg) {
		super(msg);
	}

	public NoContentException() {
		super("Nenhum registro encontrado para o Id informado");
	}

}

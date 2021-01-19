package com.basis.sge.service.servico;

public class RegraNegocioException extends RuntimeException{
    public RegraNegocioException(final String message) {
        this(message, null);
    }

    public RegraNegocioException(final String message, final Throwable cause){
        super(message, cause);
    }
}

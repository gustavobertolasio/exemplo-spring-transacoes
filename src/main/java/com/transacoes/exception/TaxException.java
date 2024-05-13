package com.transacoes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TaxException extends RuntimeException {
    public TaxException(String message) {
        super(message);
    }
}

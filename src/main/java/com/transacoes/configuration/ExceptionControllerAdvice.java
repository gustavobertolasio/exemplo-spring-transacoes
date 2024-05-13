package com.transacoes.configuration;

import com.transacoes.domain.dto.exception.response.BusinessExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<BusinessExceptionResponse> handleError (Exception e) {
        return ResponseEntity.status(400).body(BusinessExceptionResponse
                .builder()
                .code(400)
                .datetime(LocalDateTime.now())
                .message(e.getMessage())
                .build());
    }
}

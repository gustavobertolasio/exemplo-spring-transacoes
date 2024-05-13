package com.transacoes.domain.dto.exception.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
public class BusinessExceptionResponse {
    private String message;
    private LocalDateTime datetime;
    private Integer code;
}

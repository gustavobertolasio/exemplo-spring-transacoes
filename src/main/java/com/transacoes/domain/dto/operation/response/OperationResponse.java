package com.transacoes.domain.dto.operation.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationResponse {
    private Integer id;
    private Integer originAccountNumber;
    private Integer destinationAccountNumber;
    private LocalDate scheduledOperationDate;
    private BigDecimal amount;
    private Double tax;
}

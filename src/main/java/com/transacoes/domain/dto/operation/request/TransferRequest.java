package com.transacoes.domain.dto.operation.request;

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
public class TransferRequest {
    private BigDecimal originAccount;
    private BigDecimal destinationAccount;
    private BigDecimal amount;
    private LocalDate scheduledOperationDate;
    private Double transferTax;
}

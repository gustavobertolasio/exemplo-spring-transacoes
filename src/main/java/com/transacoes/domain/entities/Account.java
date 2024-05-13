package com.transacoes.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    public boolean hasAmountToOperate() { return !Objects.equals(amount, BigDecimal.ZERO);}
}

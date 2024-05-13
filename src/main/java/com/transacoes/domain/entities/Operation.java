package com.transacoes.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_origin_account", nullable = false)
    private Account originAccount;

    @ManyToOne
    @JoinColumn(name = "id_destination_account", nullable = false)
    private Account destinationAccount;

    @Column(name = "scheduledOperationDate", nullable = false)
    private LocalDate scheduledOperationDate;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "tax", nullable = false)
    private Double tax;
}

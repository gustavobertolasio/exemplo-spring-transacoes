package com.transacoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TaxService {
    @Autowired
    public TaxService() {}

    public Double getTaxByScheduledTransferDate(LocalDate scheduledTransferDate) {
        final int daysDiff = scheduledTransferDate.compareTo(LocalDate.now());
        return getTransferTax(daysDiff);
    }

    private Double getTransferTax(final int daysDiff) {
        final int category = ((daysDiff+ 9) / 10) * 10;
        return switch (category) {
            case 10 -> 0.0;
            case 20 -> 8.2;
            case 30 -> 6.9;
            case 40 -> 4.7;
            case 50 -> 1.7;
            default -> 2.5;
        };
    }
}

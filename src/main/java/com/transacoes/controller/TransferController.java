package com.transacoes.controller;

import com.transacoes.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/transfer")
public class TransferController {
    final private TaxService taxService;

    @Autowired
    public TransferController(TaxService taxService) {
        this.taxService = taxService;
    }

    @GetMapping("/{scheduledTransferDate}")
    public Double getTransferTax(@PathVariable String scheduledTransferDate) {
        return taxService.getTaxByScheduledTransferDate(LocalDate.parse(scheduledTransferDate));
    }
}

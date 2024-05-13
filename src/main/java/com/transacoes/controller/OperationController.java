package com.transacoes.controller;

import com.transacoes.domain.entities.Account;
import com.transacoes.service.AccountService;
import com.transacoes.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/transfer")
public class TransferController {
    @Autowired
     private TaxService taxService;
    @Autowired
     private AccountService accountService;

//    @Autowired
//    public TransferController(TaxService taxService,
//                              AccountService accountService) {
//        this.taxService = taxService;
//        this.accountService = accountService;
//    }

    @GetMapping("/{scheduledTransferDate}")
    public Double getTransferTax(@PathVariable String scheduledTransferDate) {
        return taxService.getTaxByScheduledTransferDate(LocalDate.parse(scheduledTransferDate));
    }


    @GetMapping()
    public List<Account> get() {
        return accountService.getAll();
    }
}

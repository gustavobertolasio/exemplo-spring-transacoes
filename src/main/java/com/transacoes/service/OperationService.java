package com.transacoes.service;

import com.transacoes.domain.dto.operation.request.TransferRequest;
import com.transacoes.domain.entities.Account;
import com.transacoes.domain.entities.Operation;
import com.transacoes.exception.DataNotFoundException;
import com.transacoes.exception.TaxException;
import com.transacoes.repository.AccountRepository;
import com.transacoes.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OperationService {
    private final AccountRepository accountRepository;
    private final OperationRepository operationRepository;
    private final TaxService taxService;

    @Autowired
    public OperationService(AccountRepository accountRepository, OperationRepository operationRepository, TaxService taxService) {
        this.accountRepository = accountRepository;
        this.operationRepository = operationRepository;
        this.taxService = taxService;
    }

    public void transfer(TransferRequest request) {
       final Account origin =  verifyAccountExistence(request.getOriginAccount());
       final Account destination = verifyAccountExistence(request.getDestinationAccount());
       final Double tax = taxService.getTaxByScheduledTransferDate(request.getScheduledOperationDate());

       if (tax == 0) { throw new TaxException("Taxa do dia não pode ser zero");}

        operationRepository.save(Operation.builder()
                .originAccount(origin)
                .destinationAccount(destination)
                .amount(request.getAmount())
                .scheduledOperationDate(request.getScheduledOperationDate())
                .tax(request.getTransferTax())
                .build());
    }

    public List<Operation> getAll() {
        return operationRepository.findAll();
    }

    private Account verifyAccountExistence(BigDecimal accountNumber) {
        return accountRepository.findByNumber(accountNumber).orElseThrow(() ->
                new DataNotFoundException("Conta não encontrada"));
    }
}

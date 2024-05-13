package com.transacoes.service;

import com.transacoes.domain.entities.Account;
import com.transacoes.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
   private AccountRepository accountRepository;

    public List<Account> getAll() {
        return accountRepository.findAll();
    }
}

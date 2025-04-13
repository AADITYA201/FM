package com.financeme.accountservice.service;

import com.financeme.accountservice.entity.Account;
import com.financeme.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public Account createAccount(Account account) {
        return repository.save(account);
    }

    public Account updateAccount(Long accountNo, Account newData) {
        Optional<Account> acc = repository.findById(accountNo);
        if (acc.isPresent()) {
            Account existing = acc.get();
            existing.setName(newData.getName());
            existing.setEmail(newData.getEmail());
            existing.setPolicyDetails(newData.getPolicyDetails());
            return repository.save(existing);
        }
        return null;
    }

    public Account viewPolicy(Long accountNo) {
        return repository.findById(accountNo).orElse(null);
    }

    public void deletePolicy(Long accountNo) {
        repository.deleteById(accountNo);
    }
}

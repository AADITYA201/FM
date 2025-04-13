package com.financeme.accountservice.controller;

import com.financeme.accountservice.entity.Account;
import com.financeme.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping("/createAccount")
    public Account create(@RequestBody Account account) {
        return service.createAccount(account);
    }

    @PutMapping("/updateAccount/{accountNo}")
    public Account update(@PathVariable Long accountNo, @RequestBody Account newData) {
        return service.updateAccount(accountNo, newData);
    }

    @GetMapping("/viewPolicy/{accountNo}")
    public Account view(@PathVariable Long accountNo) {
        return service.viewPolicy(accountNo);
    }

    @DeleteMapping("/deletePolicy/{accountNo}")
    public String delete(@PathVariable Long accountNo) {
        service.deletePolicy(accountNo);
        return "Deleted Successfully";
    }
}

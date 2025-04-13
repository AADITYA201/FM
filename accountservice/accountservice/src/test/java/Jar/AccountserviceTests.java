package com.financeme.accountservice;

import com.financeme.accountservice.entity.Account;
import com.financeme.accountservice.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = AccountserviceApplication.class) // ✅ Specify main class
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testCreateAccount() {
        Account acc = new Account(null, "Test User", "testuser@example.com", "Sample Policy");
        Account saved = accountService.createAccount(acc);
        assertNotNull(saved.getAccountNo(), "Account number should be generated");
        assertEquals("Test User", saved.getName());
    }
}

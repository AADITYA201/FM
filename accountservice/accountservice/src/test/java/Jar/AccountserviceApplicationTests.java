package com.financeme.accountservice;

import com.financeme.accountservice.entity.Account;
import com.financeme.accountservice.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = AccountserviceApplication.class)
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

    @Test
    public void testUpdateAccount() {
        Account acc = new Account(null, "Old User", "old@example.com", "Old Policy");
        Account created = accountService.createAccount(acc);

        Account newData = new Account(null, "Updated User", "new@example.com", "New Policy");
        Account updated = accountService.updateAccount(created.getAccountNo(), newData);

        assertEquals("Updated User", updated.getName());
        assertEquals("New Policy", updated.getPolicyDetails());
    }

    @Test
    public void testViewPolicy() {
        Account acc = new Account(null, "Viewer", "view@example.com", "View Policy");
        Account created = accountService.createAccount(acc);

        Account found = accountService.viewPolicy(created.getAccountNo());
        assertNotNull(found);
        assertEquals("Viewer", found.getName());
    }

    @Test
    public void testDeletePolicy() {
        Account acc = new Account(null, "Delete User", "delete@example.com", "Delete Policy");
        Account created = accountService.createAccount(acc);

        accountService.deletePolicy(created.getAccountNo());

        Account afterDelete = accountService.viewPolicy(created.getAccountNo());
        assertNull(afterDelete);
    }
}

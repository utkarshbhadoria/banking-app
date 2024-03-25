package com.devtool.banking.app.controller;

import com.devtool.banking.app.dto.AccountDto;
import com.devtool.banking.app.entity.Account;
import com.devtool.banking.app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    //dependency injection using constructor
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    private AccountService accountService;

    // Add Account Rest API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto) , HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> depositAmount(@PathVariable Long id,@RequestBody Map<String , Double> request){
        AccountDto accountDto = accountService.deposit(id , request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

}

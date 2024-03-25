package com.devtool.banking.app.service;

import com.devtool.banking.app.dto.AccountDto;
import com.devtool.banking.app.entity.Account;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id , Double amount);

    Double widraw(Long id , Double amount);
}

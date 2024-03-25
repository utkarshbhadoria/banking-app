package com.devtool.banking.app.service.impl;

import com.devtool.banking.app.dto.AccountDto;
import com.devtool.banking.app.entity.Account;
import com.devtool.banking.app.mapper.AccountMapper;
import com.devtool.banking.app.repository.AccountRepository;
import com.devtool.banking.app.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);



        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Accountdoesnot exist"));
        System.out.println(account);
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, Double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Accountdoesnot exist"));
        account.setBalance(account.getBalance()+amount);
        accountRepository.save(account);
        return AccountMapper.mapToAccountDto(account);
    }
}

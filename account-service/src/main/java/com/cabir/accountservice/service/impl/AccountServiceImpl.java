package com.cabir.accountservice.service.impl;


import com.cabir.accountservice.document.Account;
import com.cabir.accountservice.repository.AccountRepository;
import com.cabir.accountservice.service.AccountService;
import com.cabir.communicationservice.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public AccountDto save(AccountDto accountDto) {
        accountRepository.save(Account.fromMap(accountDto.toMap()));
        return accountDto;
    }

    @Override
    @Transactional
    public AccountDto findById(String id) {
        Account account =  accountRepository.findById(id).orElseThrow();
        return AccountDto.fromMap(account.toMap());
    }

    @Override
    @Transactional
    public AccountDto updateById(String id, AccountDto accountDto) {
        deleteById(id);
        save(accountDto);
        return null;
    }

    @Override
    @Transactional
    public AccountDto deleteById(String id) {
        AccountDto accountDto = AccountDto.fromMap(accountRepository.findById(id).orElseThrow().toMap());
        accountRepository.deleteById(id);
        return accountDto;
    }

    @Override
    @Transactional
    public List<AccountDto> findAllDocument() {
        List<AccountDto> accountDtoList = new ArrayList<>();
        List<Account> accountList = accountRepository.findAll();
        for (Account account: accountList) {
            accountDtoList.add(AccountDto.fromMap(account.toMap()));
        }
        return accountDtoList;
    }
}

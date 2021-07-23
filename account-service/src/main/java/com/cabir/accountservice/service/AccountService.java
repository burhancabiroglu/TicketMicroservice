package com.cabir.accountservice.service;


import com.cabir.communicationservice.AccountDto;

import java.util.List;

public interface AccountService {
    public AccountDto save(AccountDto accountDto);
    public AccountDto findById(String id);
    public AccountDto updateById(String id,AccountDto accountDto);
    public AccountDto deleteById(String id);
    public List<AccountDto> findAllDocument();
}

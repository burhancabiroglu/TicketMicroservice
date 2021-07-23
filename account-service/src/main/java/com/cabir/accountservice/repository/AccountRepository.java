package com.cabir.accountservice.repository;

import com.cabir.accountservice.document.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account,String> {
}

package com.cabir.communicationservice.client;

import com.cabir.communicationservice.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="account-service",configuration = FeignConfig.class)
public interface AccountServiceClient {

    @RequestMapping(value = "/account/{id}",method = RequestMethod.GET)
    ResponseEntity<AccountDto> get(@PathVariable("id") String id);
}
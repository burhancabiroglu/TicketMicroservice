package com.cabir.accountservice.api;


import com.cabir.accountservice.exception.ForbiddenException;
import com.cabir.accountservice.service.AccountService;
import com.cabir.communicationservice.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountApi {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto accountDto){
        return ResponseEntity.ok(accountService.save(accountDto));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<AccountDto>> findAll(){
        return ResponseEntity.ok(accountService.findAllDocument());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AccountDto> delete(@PathVariable String id){
        return ResponseEntity.ok(accountService.deleteById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> find(@PathVariable String id){
        return ResponseEntity.ok(accountService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> update(@PathVariable String id,@RequestBody AccountDto accountDto){
        return ResponseEntity.ok(accountService.updateById(id,accountDto));
    }
    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> sendViaExceptionGET() {
        throw new ForbiddenException();
    }
    @RequestMapping(value = "/exception", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> sendViaExceptionPUT() {
        throw new ForbiddenException();
    }
    @RequestMapping(value = "/exception", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> sendViaExceptionPOST() {
        throw new ForbiddenException();
    }
    @RequestMapping(value = "/exception", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> sendViaExceptionDELETE() {
        throw new ForbiddenException();
    }
}

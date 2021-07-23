package com.cabir.accountservice.document;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Account implements Serializable {
    @MongoId
    private String id;
    private String fullName;
    private String email;
    private String password;
    private Date birthDate;
    private Date createdAt;

    public HashMap<String,Object> toMap(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",this.id);
        map.put("fullName",this.fullName);
        map.put("email",this.email);
        map.put("password",this.password);
        map.put("birthDate",this.birthDate);
        map.put("createdAt",this.createdAt);
        return map;
    }

    public static Account fromMap(Map<String,Object> map){
        Account account = new Account();
        account.setId((String) map.get("id"));
        account.setFullName((String) map.get("fullName"));
        account.setEmail((String) map.get("email"));
        account.setPassword((String) map.get("password"));
        account.setBirthDate((Date) map.get("birthDate"));
        account.setCreatedAt((Date) map.get("createdAt"));
        return account;
    }
}

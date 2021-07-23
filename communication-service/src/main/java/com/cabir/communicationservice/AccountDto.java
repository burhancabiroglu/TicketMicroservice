package com.cabir.communicationservice;

import lombok.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
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

    public static AccountDto fromMap(Map<String,Object> map){
        AccountDto accountDto = new AccountDto();
        accountDto.setId((String) map.get("id"));
        accountDto.setFullName((String) map.get("fullName"));
        accountDto.setEmail((String) map.get("email"));
        accountDto.setPassword((String) map.get("password"));
        accountDto.setBirthDate((Date) map.get("birthDate"));
        accountDto.setCreatedAt((Date) map.get("createdAt"));
        return accountDto;
    }
}

package com.cabir.communicationservice;

import lombok.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketDto {

    private String id;

    private String description;

    private String notes;

    private String accountId;

    private Date ticketDate;

    private PriorityType priorityType;

    private TicketStatus ticketStatus;

    public static TicketDto fromMap(Map<String,Object> map){
        TicketDto ticketDto = new TicketDto();
        ticketDto.setId((String) map.get("id"));
        ticketDto.setDescription((String) map.get("description"));
        ticketDto.setNotes((String) map.get("notes"));
        ticketDto.setAccountId((String) map.get("accountId"));
        ticketDto.setTicketDate((Date) map.get("ticketDate"));
        ticketDto.setPriorityType((PriorityType) map.get("priorityType"));
        ticketDto.setTicketStatus((TicketStatus) map.get("ticketStatus"));
        return  ticketDto;
    }

    public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("description",description);
        map.put("notes",notes);
        map.put("accountId",accountId);
        map.put("ticketDate",ticketDate);
        map.put("priorityType",priorityType);
        map.put("ticketStatus",ticketStatus);
        return map;
    }
}
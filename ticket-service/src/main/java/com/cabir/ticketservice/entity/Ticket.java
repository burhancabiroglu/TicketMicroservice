package com.cabir.ticketservice.entity;


import com.cabir.communicationservice.PriorityType;
import com.cabir.communicationservice.TicketStatus;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tickets")
@EqualsAndHashCode(of = {"id"})
public class Ticket implements Serializable {
    @Id
    private String id;
    @Column(name = "description")
    private String description;
    @Column(name = "notes")
    private String notes;
    @Column(name = "account_id")
    private String accountId;
    @Column(name = "ticket_date")
    private Date ticketDate;
    @Column(name = "priority_type")
    @Enumerated(EnumType.ORDINAL)
    private PriorityType priorityType;
    @Column(name = "ticket_status")
    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;


    public static Ticket fromMap(Map<String,Object> map){
        Ticket ticket = new Ticket();
        ticket.setId((String) map.get("id"));
        ticket.setDescription((String) map.get("description"));
        ticket.setNotes((String) map.get("notes"));
        ticket.setAccountId((String) map.get("accountId"));
        ticket.setTicketDate((Date) map.get("ticketDate"));
        ticket.setPriorityType((PriorityType) map.get("priorityType"));
        ticket.setTicketStatus((TicketStatus) map.get("ticketStatus"));
        return  ticket;
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

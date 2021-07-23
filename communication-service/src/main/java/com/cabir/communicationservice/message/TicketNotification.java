package com.cabir.communicationservice.message;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TicketNotification {
    private String ticketId;
    private String accountId;
    private String accountFullName;
    private String accountEmail;
    private String description;

    public TicketNotification(String ticketId, String accountId, String accountFullName, String accountEmail, String description) {
        this.ticketId = ticketId;
        this.accountId = accountId;
        this.accountFullName = accountFullName;
        this.accountEmail = accountEmail;
        this.description = description;
    }
}

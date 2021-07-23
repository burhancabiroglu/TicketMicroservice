package com.cabir.ticketservice.service;


import com.cabir.communicationservice.AccountDto;
import com.cabir.ticketservice.entity.Ticket;

public interface TicketNotificationService {
    void sendToQueue(Ticket ticket, AccountDto accountDto);
}
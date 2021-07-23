package com.cabir.ticketservice.service.impl;
import com.cabir.communicationservice.AccountDto;
import com.cabir.communicationservice.message.TicketNotification;
import com.cabir.ticketservice.entity.Ticket;
import com.cabir.ticketservice.service.TicketNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@EnableBinding(Source.class)
public class TicketNotificationServiceImpl implements TicketNotificationService {


    private final Source source;

    @Override
    public void sendToQueue(Ticket ticket, AccountDto account) {
        TicketNotification ticketNotification = new TicketNotification();
        ticketNotification.setTicketId(ticket.getId());
        ticketNotification.setAccountId(ticket.getAccountId());
        ticketNotification.setAccountEmail(account.getEmail());
        ticketNotification.setDescription(ticket.getDescription());
        ticketNotification.setAccountFullName(account.getFullName());
        source.output().send(MessageBuilder.withPayload(ticketNotification).build());
    }
}

package com.cabir.ticketservice.service.impl;

import com.cabir.communicationservice.AccountDto;
import com.cabir.communicationservice.TicketDto;
import com.cabir.communicationservice.client.AccountServiceClient;
import com.cabir.ticketservice.entity.Ticket;
import com.cabir.ticketservice.exception.ForbiddenException;
import com.cabir.ticketservice.repository.TicketRepository;
import com.cabir.ticketservice.service.TicketNotificationService;
import com.cabir.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final AccountServiceClient accountServiceClient;
    private final TicketNotificationService ticketNotificationService;

    @Override
    @Transactional
    public TicketDto save(TicketDto ticketDto) {
        Ticket ticket = Ticket.fromMap(ticketDto.toMap());
        if(ticketRepository.existsById(ticketDto.getId())){
            throw new ForbiddenException();
        }
        ResponseEntity<AccountDto> accountDtoResponseEntity = accountServiceClient.get(ticketDto.getAccountId());
        if (accountDtoResponseEntity.getStatusCode().value()!=200){
            throw new ForbiddenException();
        }
        ticketRepository.save(ticket);

        ticketNotificationService.sendToQueue(ticket,accountDtoResponseEntity.getBody());
        return ticketDto;
    }

    @Override
    @Transactional
    public TicketDto update(String id, TicketDto ticketDto) {
        deleteById(id);
        return save(ticketDto);
    }

    @Override
    @Transactional
    public TicketDto findById(String ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();
        return TicketDto.fromMap(ticket.toMap());
    }

    @Override
    @Transactional
    public List<TicketDto> findAll() {
        List<Ticket> ticketList = ticketRepository.findAll();
        List<TicketDto> ticketDtoArrayList = new ArrayList<>();
        for (Ticket ticket: ticketList) {
            ticketDtoArrayList.add(TicketDto.fromMap(ticket.toMap()));
        }
        return ticketDtoArrayList;
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        ticketRepository.deleteById(id);
    }

}

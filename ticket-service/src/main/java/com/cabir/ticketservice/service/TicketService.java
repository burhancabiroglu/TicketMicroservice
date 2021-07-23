package com.cabir.ticketservice.service;


import com.cabir.communicationservice.TicketDto;

import java.util.List;

public interface TicketService {

    public TicketDto save(TicketDto ticketDto);

    public TicketDto update(String id, TicketDto ticketDto);

    public TicketDto findById(String ticketId);

    public List<TicketDto> findAll();

    public void deleteById(String id);
}
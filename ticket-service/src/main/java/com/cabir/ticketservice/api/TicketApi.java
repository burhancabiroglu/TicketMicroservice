package com.cabir.ticketservice.api;

import com.cabir.communicationservice.TicketDto;
import com.cabir.ticketservice.exception.ForbiddenException;
import com.cabir.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ticket")
@RestController
@RequiredArgsConstructor
public class TicketApi {
    private final TicketService ticketService;

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(ticketService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto) {
        return ResponseEntity.ok(ticketService.save(ticketDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDto> updateTicket(@PathVariable String id, @RequestBody TicketDto ticketDto) {
        return ResponseEntity.ok(ticketService.update(id, ticketDto));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<TicketDto>> getAll() {
        return ResponseEntity.ok(ticketService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        ticketService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
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

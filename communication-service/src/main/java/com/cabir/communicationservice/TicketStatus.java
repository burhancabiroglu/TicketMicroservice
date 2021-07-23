package com.cabir.communicationservice;

import lombok.Getter;

@Getter
public enum TicketStatus {

    OPEN("Acik"),
    IN_PROGRESS("Devam ediyor"),
    RESOLVED("Tamamlandi"),
    CLOSED("Kapandi");

    private String label;

    TicketStatus(String label){
        this.label = label;
    }
}
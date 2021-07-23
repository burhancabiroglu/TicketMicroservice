package com.cabir.communicationservice;

import lombok.Getter;

@Getter
public enum PriorityType {
    URGENT("Acil"),
    LOW("Dusuk"),
    HIGH("Onemli");

    private final String label;

    PriorityType(String label){
        this.label = label;
    }
}

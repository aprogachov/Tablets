package com.modelsale.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    
    private int id;
    private String phone;
    private int stateId;

    public Patient(String phone, int stateId) {
        this.phone = phone;
        this.stateId = stateId;
    }

}
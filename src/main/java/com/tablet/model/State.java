package com.tablet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class State {
    
    private int id;
    private String code;
    private String name;

    public State(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
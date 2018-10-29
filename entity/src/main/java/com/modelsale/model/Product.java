package com.modelsale.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    
    private int id;
    private String name;
    private int stateId;

    public Product(String name, int stateId) {
        this.name = name;
        this.stateId = stateId;
    }

}
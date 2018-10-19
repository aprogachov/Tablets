package com.tablet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    
    private int id;
    private int patientId;
    private int productId;
    private Date dateTransaction;

    public Transaction(int patientId, int productId, Date dateTransaction) {
        this.patientId = patientId;
        this.productId = productId;
        this.dateTransaction = dateTransaction;
    }

}

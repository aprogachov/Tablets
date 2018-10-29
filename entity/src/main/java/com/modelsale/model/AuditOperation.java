package com.modelsale.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditOperation {
    
    private int id;
    private Date dateAuditOperation;
    private String status;
    private String action;

    public AuditOperation(Date dateAuditOperation, String status, String action) {
        this.dateAuditOperation = dateAuditOperation;
        this.status = status;
        this.action = action;
    }

}

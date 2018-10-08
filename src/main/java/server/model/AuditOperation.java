package server.model;

import java.sql.Date;

public class AuditOperation {
    
    private int id;
    private Date dateAuditOperation;
    private String status;
    private String action;

    public AuditOperation() {
    }

    public AuditOperation(int id, Date dateAuditOperation, String status, String action) {
        this.id = id;
        this.dateAuditOperation = dateAuditOperation;
        this.status = status;
        this.action = action;
    }

    public AuditOperation(Date dateAuditOperation, String status, String action) {
        this.dateAuditOperation = dateAuditOperation;
        this.status = status;
        this.action = action;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateAuditOperation() {
        return dateAuditOperation;
    }

    public void setDateAuditOperation(Date dateAuditOperation) {
        this.dateAuditOperation = dateAuditOperation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "AuditOperation{" +
                "id=" + id +
                ", dateTransaction=" + dateAuditOperation +
                ", status='" + status + '\'' +
                ", action='" + action + '\'' +
                '}';
    }

}

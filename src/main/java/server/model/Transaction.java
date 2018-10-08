package server.model;

import java.sql.Date;

public class Transaction {
    
    private int id;
    private int patientId;
    private int productId;
    private Date dateTransaction;

    public Transaction() {
    }

    public Transaction(int id, int patientId, int productId, Date dateTransaction) {
        this.id = id;
        this.patientId = patientId;
        this.productId = productId;
        this.dateTransaction = dateTransaction;
    }

    public Transaction(int patientId, int productId, Date dateTransaction) {
        this.patientId = patientId;
        this.productId = productId;
        this.dateTransaction = dateTransaction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", productId=" + productId +
                ", dateTransaction=" + dateTransaction +
                '}';
    }
}

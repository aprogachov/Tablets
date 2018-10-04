package server.model;

public class Patient {
    
    private int id;
    private String phone;
    private int stateId;

    public Patient() {
    }
    
    public Patient(int id, String phone, int stateId) {
        this.id = id;
        this.phone = phone;
        this.stateId = stateId;
    }

    public Patient(String phone, int stateId) {
        this.phone = phone;
        this.stateId = stateId;
    }

    public int getId() {
        return id;
    }
        
    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", stateId=" + stateId +
                '}';
    }

}
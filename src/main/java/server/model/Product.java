package server.model;

public class Product {
    
    private int id;
    private String name;
    private int stateId;

    public Product() {
    }

    public Product(int id, String name, int stateId) {
        this.id = id;
        this.name = name;
        this.stateId = stateId;
    }

    public Product(String name, int stateId) {
        this.name = name;
        this.stateId = stateId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stateId=" + stateId +
                '}';
    }

}
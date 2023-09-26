package models;

public class OrderStatus {
    private int id;
    private String status;

    public OrderStatus(int id, String status) {
        this.id = id;
        this.status = status;
    }

    // Getters and setters for id and status

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

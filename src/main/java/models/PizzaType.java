package models;

public class PizzaType {
    private int id;
    private String name;

    public PizzaType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters for id and name

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
}
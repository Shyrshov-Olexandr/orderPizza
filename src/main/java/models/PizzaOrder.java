package models;

public class PizzaOrder {
    private int orderId;
    private User user; // The user who placed the order
    private PizzaType pizzaType; // The type of pizza
    private String ingredients; // List of selected ingredients
    private double totalPrice;
    private String status;
    private Pizza pizza;
    private int userId;
    private int id;

    public PizzaOrder(int orderId, User user, PizzaType pizzaType, String ingredients, double totalPrice, int status) {
        this.orderId = orderId;
        this.user = user;
        this.pizzaType = pizzaType;
        this.ingredients = ingredients;
        this.totalPrice = totalPrice;
        this.status = String.valueOf(status);
    }

    public PizzaOrder(PizzaType pizzaType, User basePrice) {

    }

    public PizzaOrder(int id, String pizzaType, String ingredients, String status, double totalPrice, int userId) {

    }

    // Getters and setters for all attributes

    public int getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
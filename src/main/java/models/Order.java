package models;

import java.util.List;

public class Order {
    private int id;
    private int userId;
    private Pizza pizza;
    private double totalPrice;
    private OrderStatus orderStatus;
    private List<Ingredient> ingredients; // List of ingredients for the pizza

    public Order(int i, int userId, List<Pizza> pizzas, double totalPrice, String status) {
        // Default constructor
    }

    public Order(int id, int userId, Pizza pizza, double totalPrice, OrderStatus orderStatus, List<Ingredient> ingredients) {
        this.id = id;
        this.userId = userId;
        this.pizza = pizza;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.ingredients = ingredients;
    }

    // Getter and setter methods for all fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
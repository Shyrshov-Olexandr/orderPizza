package services;

import DAO.OrderDAO;
import models.Order;
import models.Pizza;
import models.PizzaOrder;

import java.util.List;

public class OrderService {
    private OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public OrderService() {
    }

    public Order createOrder(int userId, List<Pizza> pizzas, double totalPrice, String status) {
        // Create a new order and store it in the database
        Order order = new Order(0, userId, pizzas, totalPrice, status); // 0 indicates a new order
        if (orderDAO.createOrder(order)) {
            return order;
        }
        return null; // Order creation failed
    }

    public PizzaOrder getOrderById(int orderId) {
        // Call the corresponding method in the OrderDAO to retrieve the order by ID
        return orderDAO.getOrderById(orderId);
    }

    public boolean updateOrderStatus(int orderId, String newStatus) {
        // Update the status of an existing order in the database
        return orderDAO.updateOrderStatus(orderId, newStatus);
    }

    public List<PizzaOrder> getUserOrders(int userId) {
        // Retrieve all orders for a specific user from the database
        return orderDAO.getOrdersByUserId(userId);
    }

    public boolean deleteOrder(int orderId) {
        // Delete an existing order from the database
        return orderDAO.deleteOrder(orderId);
    }

    public boolean updateOrderStatus(PizzaOrder pizzaOrder) {
        // Call the corresponding method in the OrderDAO to update the order status
        return orderDAO.updateOrderStatus(pizzaOrder.getOrderId(), pizzaOrder.getStatus());
    }
}
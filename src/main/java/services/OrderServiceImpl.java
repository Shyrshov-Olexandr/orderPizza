package services;

import DAO.OrderDAO;
import models.Order;
import models.PizzaOrder;
import models.User;

import java.sql.Connection;
import java.util.List;

public class OrderServiceImpl extends OrderService {
    private OrderDAO orderDAO;

    public OrderServiceImpl() {
        // Initialize OrderDAO using the provided database connection
        this.orderDAO = new OrderDAO() {
            @Override
            public List<PizzaOrder> getAllOrders() {
                return orderDAO.getAllOrders();
            }

            @Override
            public List<PizzaOrder> getOrdersByUserId(int userId) {
                return orderDAO.getOrdersByUserId(userId);
            }

            @Override
            public PizzaOrder getOrderById(int orderId) {
                return null;
            }

            @Override
            public boolean createOrder(PizzaOrder pizzaOrder) {
                return orderDAO.createOrder(pizzaOrder);
            }

            @Override
            public boolean modifyOrder(PizzaOrder pizzaOrder) {
                return orderDAO.modifyOrder(pizzaOrder);
            }

            @Override
            public boolean deleteOrder(int orderId) {
                return orderDAO.deleteOrder(orderId);
            }

            @Override
            public boolean updateOrderStatus(int orderId, String newStatus) {
                return orderDAO.updateOrderStatus(orderId, newStatus);
            }

            @Override
            public boolean createOrder(Order order) {
                return orderDAO.createOrder(order);
            }
        };
    }
}
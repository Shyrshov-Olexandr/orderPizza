package DAO;

import models.Order;
import models.PizzaOrder;

import java.util.List;

public interface OrderDAO {
    List<PizzaOrder> getAllOrders();

    List<PizzaOrder> getOrdersByUserId(int userId);

    PizzaOrder getOrderById(int orderId);

    boolean createOrder(PizzaOrder pizzaOrder);

    boolean modifyOrder(PizzaOrder pizzaOrder);

    boolean deleteOrder(int orderId);

    boolean updateOrderStatus(int orderId, String newStatus);

    boolean createOrder(Order order);
}
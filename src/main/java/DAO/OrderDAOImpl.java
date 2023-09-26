package DAO;

import models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private Connection connection;

    public OrderDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<PizzaOrder> getAllOrders() {
        List<PizzaOrder> orders = new ArrayList<>();
        String query = "SELECT * FROM pizza_orders";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String pizzaType = resultSet.getString("pizza_type");
                String ingredients = resultSet.getString("ingredients");
                String status = resultSet.getString("status");
                double totalPrice = resultSet.getDouble("total_price");
                int userId = resultSet.getInt("user_id");

                PizzaOrder pizzaOrder = new PizzaOrder(id, pizzaType, ingredients, status, totalPrice, userId);
                orders.add(pizzaOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return orders;
    }

    @Override
    public List<PizzaOrder> getOrdersByUserId(int userId) {
        List<PizzaOrder> orders = new ArrayList<>();
        String query = "SELECT * FROM pizza_orders WHERE user_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String pizzaType = resultSet.getString("pizza_type");
                String ingredients = resultSet.getString("ingredients");
                String status = resultSet.getString("status");
                double totalPrice = resultSet.getDouble("total_price");

                PizzaOrder pizzaOrder = new PizzaOrder(id, pizzaType, ingredients, status, totalPrice, userId);
                orders.add(pizzaOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return orders;
    }

    @Override
    public PizzaOrder getOrderById(int orderId) {
        String query = "SELECT * FROM pizza_orders WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String pizzaType = resultSet.getString("pizza_type");
                String ingredients = resultSet.getString("ingredients");
                String status = resultSet.getString("status");
                double totalPrice = resultSet.getDouble("total_price");
                int userId = resultSet.getInt("user_id");

                return new PizzaOrder(id, pizzaType, ingredients, status, totalPrice, userId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return null; // Order not found
    }

    @Override
    public boolean createOrder(PizzaOrder pizzaOrder) {
        String query = "INSERT INTO pizza_orders (pizza_type, ingredients, status, total_price, user_id) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, String.valueOf(pizzaOrder.getPizzaType()));
            preparedStatement.setString(2, String.valueOf(pizzaOrder.getIngredients()));
            preparedStatement.setString(3, pizzaOrder.getStatus());
            preparedStatement.setDouble(4, pizzaOrder.getTotalPrice());
            preparedStatement.setInt(5, pizzaOrder.getUserId());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0; // If rowsInserted > 0, the insertion was successful
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return false; // Order creation failed
    }

    @Override
    public boolean modifyOrder(PizzaOrder pizzaOrder) {
        String query = "UPDATE pizza_orders SET pizza_type = ?, ingredients = ?, status = ?, total_price = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, String.valueOf(pizzaOrder.getPizzaType()));
            preparedStatement.setString(2, String.valueOf(pizzaOrder.getIngredients()));
            preparedStatement.setString(3, pizzaOrder.getStatus());
            preparedStatement.setDouble(4, pizzaOrder.getTotalPrice());
            preparedStatement.setInt(5, pizzaOrder.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0; // If rowsUpdated > 0, the modification was successful
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return false; // Order modification failed
    }

    @Override
    public boolean createOrder(Order order) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // SQL query to insert a new order into the orders table
            String insertOrderQuery = "INSERT INTO orders (user_id, pizza_id, total_price, order_status_id) " +
                    "VALUES (?, ?, ?, ?)";

            // Create a prepared statement
            preparedStatement = connection.prepareStatement(insertOrderQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, order.getUserId());
            preparedStatement.setInt(2, order.getPizza().getId());
            preparedStatement.setDouble(3, order.getTotalPrice());

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            // If the query was successful, set the generated order ID in the Order object
            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    int orderId = resultSet.getInt(1);
                    order.setId(orderId);
                    return true; // Order creation was successful
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any database-related exceptions here
        } finally {
            // Close the result set, prepared statement, and any other resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle any closing-related exceptions here
            }
        }

        return false; // Order creation failed
    }

    @Override
    public boolean deleteOrder(int orderId) {
        String query = "DELETE FROM pizza_orders WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, orderId);

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0; // If rowsDeleted > 0, the deletion was successful
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return false; // Order deletion failed
    }

    @Override
    public boolean updateOrderStatus(int orderId, String newStatus) {
        String query = "UPDATE pizza_orders SET status = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newStatus);
            preparedStatement.setInt(2, orderId);

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0; // If rowsUpdated > 0, the update was successful
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return false; // Order status update failed
    }
}
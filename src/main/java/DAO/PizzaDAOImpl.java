package DAO;

import models.Pizza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PizzaDAOImpl implements PizzaDAO {
    private Connection connection;

    public PizzaDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Pizza> getAllPizzaTypes() {
        List<Pizza> pizzaTypes = new ArrayList<>();
        String query = "SELECT * FROM pizzas";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");

                Pizza pizza = new Pizza(id, name, price);
                pizzaTypes.add(pizza);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return pizzaTypes;
    }

    @Override
    public Pizza getPizzaById(int id) {
        String query = "SELECT * FROM pizzas WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");

                return new Pizza(id, name, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return null; // Pizza type not found
    }

    @Override
    public boolean addPizza(Pizza pizza) {
        String query = "INSERT INTO pizzas (name, price) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, pizza.getName());
            preparedStatement.setDouble(2, pizza.getPrice());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0; // If rowsInserted > 0, the insertion was successful
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return false; // Pizza type addition failed
    }

    @Override
    public boolean modifyPizza(Pizza pizza) {
        String query = "UPDATE pizzas SET name = ?, price = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, pizza.getName());
            preparedStatement.setDouble(2, pizza.getPrice());
            preparedStatement.setInt(3, pizza.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0; // If rowsUpdated > 0, the modification was successful
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return false; // Pizza type modification failed
    }

    @Override
    public boolean deletePizza(int id) {
        String query = "DELETE FROM pizzas WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0; // If rowsDeleted > 0, the deletion was successful
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return false; // Pizza type deletion failed
    }
}

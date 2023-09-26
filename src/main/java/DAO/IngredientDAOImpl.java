package DAO;

import models.Ingredient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAOImpl implements IngredientDAO {
    private Connection connection;

    public IngredientDAOImpl(Connection connection) {
        // Initialize the connection in the constructor
        this.connection = connection;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        String query = "SELECT * FROM ingredients";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");

                Ingredient ingredient = new Ingredient(id, name, price);
                ingredients.add(ingredient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return ingredients;
    }

    @Override
    public Ingredient getIngredientById(int id) {
        String query = "SELECT * FROM ingredients WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");

                return new Ingredient(id, name, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return null; // Ingredient not found
    }

    @Override
    public boolean addIngredient(Ingredient ingredient) {
        String query = "INSERT INTO ingredients (name, price) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, ingredient.getName());
            preparedStatement.setDouble(2, ingredient.getPrice());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0; // If rowsInserted > 0, the addition was successful
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return false; // Ingredient addition failed
    }

    @Override
    public boolean modifyIngredient(Ingredient ingredient) {
        String query = "UPDATE ingredients SET name = ?, price = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, ingredient.getName());
            preparedStatement.setDouble(2, ingredient.getPrice());
            preparedStatement.setInt(3, ingredient.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0; // If rowsUpdated > 0, the modification was successful
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return false; // Ingredient modification failed
    }

    @Override
    public boolean deleteIngredient(int id) {
        String query = "DELETE FROM ingredients WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0; // If rowsDeleted > 0, the deletion was successful
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return false; // Ingredient deletion failed
    }
}

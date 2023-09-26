package DAO;

import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    private Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User getUserById(int userId) {
        String query = "SELECT * FROM users WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                // You can retrieve other user attributes as needed

                return new User(userId, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return null; // User not found
    }

    @Override
    public User getUserByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String password = resultSet.getString("password");
                // You can retrieve other user attributes as needed

                return new User(userId, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return null; // User not found
    }

    @Override
    public boolean createUser(User user) {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0; // If rowsInserted > 0, the insertion was successful
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return false; // User creation failed
    }

    @Override
    public boolean updateUser(User user) {
        String query = "UPDATE users SET username = ?, password = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0; // If rowsUpdated > 0, the modification was successful
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return false; // User modification failed
    }

    @Override
    public boolean deleteUser(int userId) {
        String query = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0; // If rowsDeleted > 0, the deletion was successful
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return false; // User deletion failed
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        String query = "SELECT COUNT(*) AS count FROM users WHERE username = ? AND password = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0; // If count > 0, authentication was successful
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return false; // Authentication failed
    }
}
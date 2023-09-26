package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderStatusDAOImpl implements OrderStatusDAO {
    private Connection connection;

    public OrderStatusDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<String> getAllOrderStatuses() {
        List<String> statuses = new ArrayList<>();
        String query = "SELECT status FROM order_status";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String status = resultSet.getString("status");
                statuses.add(status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return statuses;
    }

    @Override
    public boolean isValidStatus(String status) {
        String query = "SELECT COUNT(*) AS count FROM order_status WHERE status = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, status);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0; // If count > 0, the status is valid
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return false; // Status not found or invalid
    }
}
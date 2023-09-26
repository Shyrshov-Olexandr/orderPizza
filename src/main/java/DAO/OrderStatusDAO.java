package DAO;

import java.util.List;

public interface OrderStatusDAO {
    List<String> getAllOrderStatuses();

    boolean isValidStatus(String status);
}

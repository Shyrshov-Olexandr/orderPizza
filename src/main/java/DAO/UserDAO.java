package DAO;

import models.User;

public interface UserDAO {
    User getUserById(int userId);

    User getUserByUsername(String username);

    boolean createUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int userId);

    boolean authenticateUser(String username, String password);
}
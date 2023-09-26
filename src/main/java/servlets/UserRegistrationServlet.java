package servlets;
import DAO.UserDAO;
import DAO.UserDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/register")
public class UserRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the registration page (replace with your actual registration page)
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user registration data from the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // Validate user registration data (you should implement validation logic)
        if (username != null && password != null && password.equals(confirmPassword)) {
            // Registration data is valid

            // Create a User object for the new user
            User newUser = new User(username, password); // You may include additional user attributes

            // Insert the new user into the database
            Connection connection = (Connection) getServletContext().getAttribute("dbConnection");
            UserDAO userDAO = new UserDAOImpl(connection);
            if (userDAO.createUser(newUser)) {
                // User registration successful

                // Redirect to the login page or another appropriate page
                response.sendRedirect(request.getContextPath() + "/login");
            } else {
                // User registration failed, display an error message
                request.setAttribute("errorMessage", "User registration failed. Please try again.");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        } else {
            // Registration data is invalid, display an error message
            request.setAttribute("errorMessage", "Invalid registration data. Please try again.");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}
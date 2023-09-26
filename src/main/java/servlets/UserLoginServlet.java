package servlets;

import DAO.UserDAO;
import DAO.UserDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the login page (replace with your actual login page)
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user input from the login form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate the user credentials (you should implement user authentication logic)
        Connection connection = (Connection) getServletContext().getAttribute("dbConnection");
        UserDAO userDAO = new UserDAOImpl(connection);
        boolean authenticatedUser = userDAO.authenticateUser(username, password);

        if (authenticatedUser) {
            // User authenticated successfully

            // Create a session for the user
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedInUser", authenticatedUser);

            // Redirect to the main page or another protected page
            response.sendRedirect(request.getContextPath() + "/main");
        } else {
            // Authentication failed, display an error message
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
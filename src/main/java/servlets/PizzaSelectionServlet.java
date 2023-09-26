package servlets;

import DAO.PizzaDAO;
import DAO.PizzaDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Pizza;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/pizza-selection")
public class PizzaSelectionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve pizza types from the database using your PizzaDAO implementation
        Connection connection = (Connection) getServletContext().getAttribute("dbConnection");
        PizzaDAO pizzaDAO = new PizzaDAOImpl(connection);
        List<Pizza> pizzaTypes = pizzaDAO.getAllPizzaTypes();

        // Set pizza types as a request attribute
        request.setAttribute("pizzaTypes", pizzaTypes);

        // Forward the request to the pizza selection page (replace with your actual JSP page name)
        request.getRequestDispatcher("/pizza-selection.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the selected pizza type from the form (replace "selectedPizza" with your actual form field name)
        int selectedPizzaId = Integer.parseInt(request.getParameter("selectedPizza"));

        // Store the selected pizza type in the session (or another appropriate location)
        request.getSession().setAttribute("selectedPizzaId", selectedPizzaId);

        // Redirect to the next step, such as ingredient selection (replace with the appropriate URL)
        response.sendRedirect(request.getContextPath() + "/ingredient-selection");
    }
}
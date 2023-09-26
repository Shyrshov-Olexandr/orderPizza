package servlets;

import DAO.PizzaDAO;
import DAO.PizzaDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Pizza;
import models.PizzaOrder;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/order-summary.jsp")
public class OrderSummaryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the selected pizza order from the session (assuming you have stored it there)
        PizzaOrder pizzaOrder = (PizzaOrder) request.getSession().getAttribute("pizzaOrder");

        if (pizzaOrder == null) {
            // Handle the case where there is no pizza order in the session (e.g., redirect to the pizza selection page)
            response.sendRedirect(request.getContextPath() + "/pizza-selection");
            return;
        }

        // Retrieve pizza type details from the database using your PizzaDAO implementation
        Connection connection = (Connection) getServletContext().getAttribute("dbConnection");
        PizzaDAO pizzaDAO = new PizzaDAOImpl(connection);
        Pizza selectedPizza = pizzaDAO.getPizzaById(pizzaOrder.getPizza().getId());

        // Set the pizza order and selected pizza as request attributes
        request.setAttribute("pizzaOrder", pizzaOrder);
        request.setAttribute("selectedPizza", selectedPizza);

        // Forward the request to the order summary page (replace with your actual JSP page name)
        request.getRequestDispatcher("/order-summary.jsp.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check the action parameter sent from the order summary page
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("confirmOrder")) {
                // Handle the action to confirm the order
                // For example, you can update the order status, store it in the database, and proceed accordingly
                // Replace with your actual order update and database storage logic

                // Redirect to a confirmation page or a thank you page
                response.sendRedirect(request.getContextPath() + "/confirmation");
            } else if (action.equals("modifyOrder")) {
                // Handle the action to modify the order
                // You can redirect the user to the order modification page or another appropriate page
                // Replace with your actual redirection logic

                // Redirect to the order modification page
                response.sendRedirect(request.getContextPath() + "/order-modification");
            }
        } else {
            // Handle the case where no action parameter is provided
            // You can display an error message or redirect to an error page
            String errorMessage = "No action parameter provided. Please try again.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("/error-page.jsp").forward(request, response);
        }
    }
}

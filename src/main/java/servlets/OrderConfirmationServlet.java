package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.PizzaOrder;

import java.io.IOException;

@WebServlet("/order-confirmation")
public class OrderConfirmationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the pizza order from the session
        PizzaOrder pizzaOrder = (PizzaOrder) request.getSession().getAttribute("pizzaOrder");

        if (pizzaOrder != null) {
            // Forward the order details to the JSP for rendering
            request.setAttribute("pizzaOrder", pizzaOrder);
            request.getRequestDispatcher("order-confirmation.jsp").forward(request, response);
        } else {
            // Handle the case where the pizza order is not found
            response.getWriter().println("Pizza order not found.");
        }
    }
}
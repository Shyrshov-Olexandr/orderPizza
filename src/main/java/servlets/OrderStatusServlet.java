package servlets;

import DAO.OrderDAO;
import DAO.OrderDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.PizzaOrder;
import models.User;
import services.OrderService;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/order-status")
public class OrderStatusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private OrderService orderService; // Assuming you have an OrderService to manage orders

    public void init() throws ServletException {
        // Initialize the OrderService (you may need to inject it)
        orderService = new OrderService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the order ID from the request
        String orderIdStr = request.getParameter("orderId");

        if (orderIdStr != null && !orderIdStr.isEmpty()) {
            try {
                int orderId = Integer.parseInt(orderIdStr);

                // Retrieve the pizza order from the OrderService
                PizzaOrder pizzaOrder = orderService.getOrderById(orderId);

                if (pizzaOrder != null) {
                    // Forward the order details to a JSP for rendering
                    request.setAttribute("pizzaOrder", pizzaOrder);
                    request.getRequestDispatcher("order-status.jsp").forward(request, response);
                    return;
                }
            } catch (NumberFormatException e) {
                // Handle invalid order ID format
                e.printStackTrace();
            }
        }

        // Handle invalid input or order not found
        response.getWriter().println("Invalid order ID or order not found.");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the order ID and updated status from the form
        String orderIdStr = request.getParameter("orderId");
        String newStatus = request.getParameter("newStatus");

        if (orderIdStr != null && newStatus != null && !orderIdStr.isEmpty() && !newStatus.isEmpty()) {
            try {
                int orderId = Integer.parseInt(orderIdStr);

                // Retrieve the pizza order from the OrderService
                PizzaOrder pizzaOrder = orderService.getOrderById(orderId);

                if (pizzaOrder != null) {
                    // Update the order status
                    pizzaOrder.setStatus(newStatus);

                    // Save the updated order in the OrderService or database
                    orderService.updateOrderStatus(pizzaOrder);

                    // Redirect back to the order status page
                    response.sendRedirect("order-status?orderId=" + orderId);
                    return;
                }
            } catch (NumberFormatException e) {
                // Handle invalid order ID format
                e.printStackTrace();
            }
        }

        // Handle invalid input or order not found
        response.getWriter().println("Invalid input or order not found.");
    }
}
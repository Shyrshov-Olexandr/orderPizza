package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.PizzaOrder;
import services.OrderService;

import java.io.IOException;

@WebServlet("/order-modification")
public class OrderModificationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private OrderService orderService; // Assuming you have an OrderService to manage orders

    public void init() throws ServletException {
        // Initialize the OrderService (you may need to inject it)
        // Example: orderService = new OrderService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the order ID from the request
        String orderIdStr = request.getParameter("orderId");

        if (orderIdStr != null && !orderIdStr.isEmpty()) {
            try {
                int orderId = Integer.parseInt(orderIdStr);

                // Retrieve the pizza order from the OrderService
                PizzaOrder pizzaOrder = orderService.getOrderById(orderId);

                if (pizzaOrder != null) {
                    // Implement your logic for modifying or canceling the order
                    // This may include updating order details or deleting the order

                    // After handling the request, you can redirect the user to a confirmation page
                    response.sendRedirect("order-confirmation.jsp");
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
}

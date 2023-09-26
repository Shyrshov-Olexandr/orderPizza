package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Ingredient;
import models.PizzaOrder;
import services.IngredientService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/add-ingredients")
public class AddIngredientsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the selected ingredients from the form
        String[] selectedIngredients = request.getParameterValues("ingredient");

        if (selectedIngredients != null && selectedIngredients.length > 0) {
            // Get the existing pizza order from the session
            HttpSession session = request.getSession();
            PizzaOrder pizzaOrder = (PizzaOrder) session.getAttribute("pizzaOrder");

            if (pizzaOrder != null) {
                // Create a list to store the selected ingredients
                List<Ingredient> ingredients = new ArrayList<>();

                // Assuming you have an IngredientService to fetch ingredient details
                IngredientService ingredientService = new IngredientService();

                for (String ingredientId : selectedIngredients) {
                    // Fetch ingredient details by ID
                    int ingredientIdInt = Integer.parseInt(ingredientId);
                    Ingredient ingredient = ingredientService.getIngredientById(ingredientIdInt);

                    if (ingredient != null) {
                        // Add the ingredient to the list
                        ingredients.add(ingredient);
                    }
                }

                // Set the selected ingredients in the pizza order
                pizzaOrder.setIngredients(ingredients.toString());

                // Calculate and update the total price based on the selected ingredients
                double totalPrice = calculateTotalPrice(pizzaOrder, ingredients);
                pizzaOrder.setTotalPrice(totalPrice);

                // Update the pizza order in the session
                session.setAttribute("pizzaOrder", pizzaOrder);
            }
        }

        // Redirect to the pizza customization page or any other page as needed
        response.sendRedirect("customize-pizza.jsp");
    }

    // Calculate total price based on pizza and selected ingredients
    private double calculateTotalPrice(PizzaOrder pizzaOrder, List<Ingredient> selectedIngredients) {
        double pizzaPrice = pizzaOrder.getPizza().getPrice();
        double ingredientPrice = selectedIngredients.stream().mapToDouble(Ingredient::getPrice).sum();
        return pizzaPrice + ingredientPrice;
    }
}
package services;

import DAO.IngredientDAO;
import models.Ingredient;

import java.util.List;

public class IngredientService {
    private IngredientDAO ingredientDAO;

    public IngredientService(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    public IngredientService() {

    }

    public List<Ingredient> getAllIngredients() {
        // Retrieve a list of all available ingredients
        return ingredientDAO.getAllIngredients();
    }

    public Ingredient getIngredientById(int ingredientId) {
        // Retrieve an ingredient by its ID
        return ingredientDAO.getIngredientById(ingredientId);
    }

    public boolean addIngredient(Ingredient ingredient) {
        // Add a new ingredient to the database
        return ingredientDAO.addIngredient(ingredient);
    }

//    public boolean updateIngredient(Ingredient ingredient) {
//        // Update an existing ingredient in the database
//        return ingredientDAO.updateIngredient(ingredient);
//    }

    public boolean deleteIngredient(int ingredientId) {
        // Delete an ingredient from the database by its ID
        return ingredientDAO.deleteIngredient(ingredientId);
    }
}

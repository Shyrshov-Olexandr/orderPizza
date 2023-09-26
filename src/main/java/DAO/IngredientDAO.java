package DAO;

import models.Ingredient;
import java.util.List;

public interface IngredientDAO {
    List<Ingredient> getAllIngredients();

    Ingredient getIngredientById(int id);

    boolean addIngredient(Ingredient ingredient);

    boolean modifyIngredient(Ingredient ingredient);

    boolean deleteIngredient(int id);
}
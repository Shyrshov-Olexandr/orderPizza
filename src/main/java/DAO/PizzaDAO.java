package DAO;

import models.Pizza;


import java.util.List;

public interface PizzaDAO {
    List<Pizza> getAllPizzaTypes();

    Pizza getPizzaById(int id);

    boolean addPizza(Pizza pizza);

    boolean modifyPizza(Pizza pizza);

    boolean deletePizza(int id);
}
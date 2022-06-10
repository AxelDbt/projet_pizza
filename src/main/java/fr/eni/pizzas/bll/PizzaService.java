package fr.eni.pizzas.bll;

import java.util.List;

import fr.eni.pizzas.bo.Pizza;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface PizzaService {
	List<Pizza> getPizzas();
	Pizza addPizza(Pizza pizza);
	Pizza getPizzaById(int id);
	void deletePizza(int id);
	ResponseEntity<Pizza> udpatePizza(int id, Pizza pizza);
}

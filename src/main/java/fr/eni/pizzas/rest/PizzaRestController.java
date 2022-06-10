package fr.eni.pizzas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import fr.eni.pizzas.bo.Pizza;
import fr.eni.pizzas.bll.PizzaService;

@RestController
@RequestMapping("rest")
public class PizzaRestController {

	private PizzaService pizzaService;

	@Autowired
	public PizzaRestController(PizzaService pizzaService) {
		this.pizzaService = pizzaService;
	}

	@GetMapping("/pizzas")
	public List<Pizza> getPizzas() {
		return this.pizzaService.getPizzas();
	}

	@GetMapping("/pizzas/{id}")
	public Pizza getPizza(@PathVariable("id") int id) {
		Pizza pizza = this.pizzaService.getPizzaById(id);
		return pizza;
	}

	@PostMapping("/pizza")
	public ResponseEntity<Pizza> ajouterPizza(@RequestBody Pizza pizza) {
		try {
			Pizza _pizza = this.pizzaService.addPizza(new Pizza(pizza.getNom(),pizza.getDescription(),pizza.getImage(),pizza.getPrix()));
			return new ResponseEntity<>(_pizza, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/pizza/{id}")
	public void updatePizza(@PathVariable Integer id,@RequestBody Pizza pizza) {
		System.out.println(pizza.getNom());
		System.out.println(id);
			Pizza _pizza = getPizza(id);
			if(_pizza != null){
				this.pizzaService.udpatePizza(id, pizza);
			}

	}

	@DeleteMapping("/pizza/{id}")
	public void deletePizza(@PathVariable("id") int id) {
		this.pizzaService.deletePizza(id);
	}

}










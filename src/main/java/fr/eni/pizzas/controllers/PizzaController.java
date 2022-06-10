package fr.eni.pizzas.controllers;

import fr.eni.pizzas.bo.Pizza;
import fr.eni.pizzas.bll.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller("pizzaBean")
public class PizzaController {

	private PizzaService pizzaService;

	@Autowired
	public PizzaController (PizzaService pizzaService) {
		this.pizzaService = pizzaService;
	}

	@GetMapping({"", "/", "/index"})
	public String index() {
		return "index";
	}

	@GetMapping("/detail/{id}")
	public String detail(@PathVariable int id, Model model) {
		Pizza pizza = this.pizzaService.getPizzaById(id);
		model.addAttribute("pizza",pizza);
		return "detail";
	}

	@GetMapping("/add")
	public String add() {
		return "ajout";
	}

}

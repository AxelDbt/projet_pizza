package fr.eni.pizzas.bll;

import fr.eni.pizzas.bo.Pizza;
import fr.eni.pizzas.dal.PizzaRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("default")
public class PizzaServiceImpl implements PizzaService {

	private PizzaRepository pizzaRepository;

	public PizzaServiceImpl(PizzaRepository pizzaRepository) {
		super();
		this.pizzaRepository = pizzaRepository;
	}

	@Override
	public List<Pizza> getPizzas() {
		return this.pizzaRepository.findAll();
	}

	@Override
	public Pizza getPizzaById(int id) {
		return this.pizzaRepository.getById((long) id);
	}


	@Override
	public Pizza addPizza(Pizza pizza) {
		this.pizzaRepository.save(pizza);
		return pizza;
	}

	@Override
	public void deletePizza(int id) {
			this.pizzaRepository.delete(getPizzaById(id));
	}

	@Override
	public ResponseEntity<Pizza> udpatePizza(int id, Pizza pizza) {
		Pizza _pizza = getPizzaById(id);
		if(pizza != null){
			_pizza.setNom(pizza.getNom());
			_pizza.setDescription(pizza.getDescription());
			_pizza.setImage(pizza.getImage());
			_pizza.setPrix(pizza.getPrix());
			this.pizzaRepository.save(pizza);
			return new ResponseEntity<>(_pizza, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}

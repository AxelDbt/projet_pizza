package fr.eni.pizzas.dal;

import fr.eni.pizzas.bo.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}

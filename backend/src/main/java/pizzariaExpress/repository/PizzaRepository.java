package pizzariaExpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pizzariaExpress.model.Pizza;

public interface PizzaRepository  extends JpaRepository<Pizza, Integer> {
}

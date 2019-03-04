package pizzariaExpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pizzariaExpress.dto.PizzaDTO;
import pizzariaExpress.model.Pizza;
import pizzariaExpress.repository.PizzaRepository;

import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> findAll(){
        return this.pizzaRepository.findAll();
    }

    public Pizza save(Pizza pizza){
        return this.pizzaRepository.save(pizza);
    }

    public Pizza save(PizzaDTO pizzaDTO){
        return this.pizzaRepository.save(converterPizzaDTO(pizzaDTO));
    }

    public Pizza findById(Integer id){
        return this.pizzaRepository.findById(id).orElse(null);
    }

    public Pizza update(Integer id, PizzaDTO pizzaDTO){
        Pizza pizzaEncontrada = findById(id);
        if (pizzaEncontrada != null){
            pizzaEncontrada.setId(id);
            pizzaEncontrada.setNome(pizzaDTO.getNome());
            pizzaEncontrada.setCodigo(pizzaDTO.getCodigo());
            pizzaEncontrada.setValor(pizzaDTO.getValor());
            return save(pizzaEncontrada);
        }
        return null;
    }

    public void delete(Integer id){
        Pizza pizzaEncontrada = findById(id);
        if (pizzaEncontrada != null){
            this.pizzaRepository.delete(pizzaEncontrada);
        }
    }


    private Pizza converterPizzaDTO(PizzaDTO pizzaDTO) {
        Pizza pizza = new Pizza();
        pizza.setId(pizzaDTO.getId());
        pizza.setNome(pizzaDTO.getNome());
        pizza.setCodigo(pizzaDTO.getCodigo());
        pizza.setValor(pizzaDTO.getValor());
        return pizza;
    }

}

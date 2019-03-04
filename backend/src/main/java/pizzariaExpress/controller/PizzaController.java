package pizzariaExpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pizzariaExpress.dto.PizzaDTO;
import pizzariaExpress.model.Pizza;
import pizzariaExpress.service.PizzaService;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Pizza> pizzas = this.pizzaService.findAll();
        return ResponseEntity.ok(pizzas);
    }

    @GetMapping("/{id}")
    public Pizza findById(@PathVariable Integer id){
        return pizzaService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody PizzaDTO pizzaDTO){
        this.pizzaService.save(pizzaDTO);
    }

    @PutMapping("/{id}")
    public Pizza update(@PathVariable Integer id, @RequestBody PizzaDTO pizzaDTO){
        return this.pizzaService.update(id, pizzaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        this.pizzaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

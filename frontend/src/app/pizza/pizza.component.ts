import { Component, OnInit } from '@angular/core';
import { PizzaService } from './pizza.service';

@Component({
  selector: 'app-pizza',
  templateUrl: './pizza.component.html',
  styleUrls: ['./pizza.component.css']
})

export class PizzaComponent implements OnInit {
  listaPizzas = [];
  constructor(private pizzaService: PizzaService) {
  }


  ngOnInit() {
    this.buscarPizzas();
  }

  buscarPizzas(){
    this.pizzaService.buscarPizzas().subscribe(
      resource => {console.log(resource);}
    )
  }
}

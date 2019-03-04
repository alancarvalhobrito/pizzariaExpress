import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Pizza } from '../model/pizza';

@Injectable({
  providedIn: 'root'
})
export class PizzaService {

  private readonly API = "/api/pizzas";
  constructor(private http: HttpClient) {

   }

  buscarPizzas(){
    return this.http.get<Pizza>(this.API);
  }
}

package pizzariaExpress.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaDTO {

    private Integer id;
    private String nome;
    private String codigo;
    private double valor;

    public PizzaDTO() {
    }

    public PizzaDTO(Integer id, String nome, String codigo, double valor) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.valor = valor;
    }
}

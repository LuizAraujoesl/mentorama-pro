package br.com.mentorama.aloMundo.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ProdutosSelecionados {
    private  Integer id;
    private Produtos produtos;
    private double discount;
    private  double total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

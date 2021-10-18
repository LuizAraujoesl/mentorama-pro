package br.com.mentorama.aloMundo.entities;

import org.springframework.stereotype.Component;

@Component
public class Cesta {
    private  ProdutosSelecionados produtosSelecionados;
    private double total;

    public ProdutosSelecionados getProdutosSelecionados() {
        return produtosSelecionados;
    }

    public void setProdutosSelecionados(ProdutosSelecionados produtosSelecionados) {
        this.produtosSelecionados = produtosSelecionados;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

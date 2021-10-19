package br.com.mentorama.aloMundo.entities;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cesta {
    private List<ItemCarrinho> itemCarrinho;
    private double descount;
    private double total;

    public Cesta(){
        itemCarrinho =  new ArrayList<>();
    }

    public List<ItemCarrinho> getItemCarrinho() {
        return itemCarrinho;
    }

    public void setItemCarrinho(ItemCarrinho itemCarrinho) {
        this.itemCarrinho.add(itemCarrinho);
    }

    public double getDescount() {
        return descount;
    }

    public void setDescount(double descount) {
        this.descount = descount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

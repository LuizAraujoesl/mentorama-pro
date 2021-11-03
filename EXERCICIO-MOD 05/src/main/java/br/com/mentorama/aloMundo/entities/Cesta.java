package br.com.mentorama.aloMundo.entities;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cesta {

    //atributos cesta
    private List<ItensCesta> itensCesta;
    private double descount;
    private double total;

    // Construtor
    public Cesta(){
        itensCesta =  new ArrayList<>();
    }

    public List<ItensCesta> getItemCarrinho() {
        return itensCesta;
    }

    // Getter and Setters
    public void setItemCarrinho(ItensCesta itensCesta) {
        this.itensCesta.add(itensCesta);
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

    @Override
    public String toString() {
        return "Cesta{" +
                "itensCesta=" + itensCesta +
                ", descount=" + descount +
                ", total=" + total +
                '}';
    }
}

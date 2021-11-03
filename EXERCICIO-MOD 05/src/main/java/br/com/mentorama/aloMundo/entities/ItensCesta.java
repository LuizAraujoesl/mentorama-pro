package br.com.mentorama.aloMundo.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ItensCesta {

    // Atribustos Intem cesta
    private  Integer id;
    private String name;
    private double price;

    // Getter and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {return price;}

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ItensCesta{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

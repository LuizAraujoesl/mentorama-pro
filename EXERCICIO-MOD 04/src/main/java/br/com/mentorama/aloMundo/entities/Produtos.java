package br.com.mentorama.aloMundo.entities;

public class Produtos {
    private  Integer id;
    private String type;
    private String name;
    private double price;
    private int amount;

    public Produtos(Integer id, String type, String name, double price, int amount) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
        this.amount =  amount;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenssagem() {
        return name;
    }

    public void setMenssagem(String menssagem) {
        this.name = menssagem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

package br.com.mentorama.aloMundo;

public class Menssage  {
    private  Integer id;
    private String menssagem;

    public Menssage(Integer id, String menssagem) {
        this.id = id;
        this.menssagem = menssagem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenssagem() {
        return menssagem;
    }

    public void setMenssagem(String menssagem) {
        this.menssagem = menssagem;
    }


}

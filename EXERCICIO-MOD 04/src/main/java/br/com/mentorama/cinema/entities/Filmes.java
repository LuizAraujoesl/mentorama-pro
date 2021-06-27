package br.com.mentorama.cinema.entities;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Filmes {
    private  Integer filmeId;
    private  String filmeNome;
    private String diretorNome;
    private String filmeAno;
    private Integer filmeNota;

    public Filmes() {
    }


    public Filmes(Integer filmeId, String filmeNome, String diretorNome,
                  String filmeAno, Integer filmeNota) {
        this.filmeId = filmeId;
        this.filmeNome = filmeNome;
        this.diretorNome = diretorNome;
        this.filmeAno = filmeAno;
        this.filmeNota = filmeNota;
    }


    public Integer getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(Integer filmeId) {
        this.filmeId = filmeId;
    }

    public String getFilmeNome() {
        return filmeNome;
    }

    public void setFilmeNome(String filmeNome) {
        this.filmeNome = filmeNome;
    }

    public String getDiretorNome() {
        return diretorNome;
    }

    public void setDiretorNome(String diretorNome) {
        this.diretorNome = diretorNome;
    }

    public String getFilmeAno() {
        return filmeAno;
    }

    public void setFilmeAno(String filmeAno) {
        this.filmeAno = filmeAno;
    }

    public Integer getFilmeNota() {
        return filmeNota;
    }

    public void setFilmeNota(Integer filmeNota) {
        this.filmeNota = filmeNota;
    }
}

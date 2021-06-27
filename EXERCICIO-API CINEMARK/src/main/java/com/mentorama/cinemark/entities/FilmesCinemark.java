package com.mentorama.cinemark.entities;

import java.util.Objects;

public class FilmesCinemark {

    private  Integer idFilme;
    private  String nomeFilme;
    private  String nomeDiretor;
    private  String anoFilme;
    private  Integer notaFilme;


    //Construtor sobrecarga
    public FilmesCinemark(){

    }

    //Construtor
    public FilmesCinemark(Integer idFilme, String nomeFilme, String nomeDiretor, String anoFilme, Integer notaFilme) {
        this.idFilme = idFilme;
        this.nomeFilme = nomeFilme;
        this.nomeDiretor = nomeDiretor;
        this.anoFilme = anoFilme;
        this.notaFilme = notaFilme;
    }


    // Getter and Setter
    public Integer getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Integer idFilme) {
        this.idFilme = idFilme;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    public String getAnoFilme() {
        return anoFilme;
    }

    public void setAnoFilme(String anoFilme) {
        this.anoFilme = anoFilme;
    }

    public Integer getNotaFilme() {
        return notaFilme;
    }

    public void setNotaFilme(Integer notaFilme) {
        this.notaFilme = notaFilme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilmesCinemark)) return false;
        FilmesCinemark that = (FilmesCinemark) o;
        return getIdFilme().equals(that.getIdFilme()) && getNomeFilme().equals(that.getNomeFilme()) && getNomeDiretor().equals(that.getNomeDiretor()) && getAnoFilme().equals(that.getAnoFilme()) && getNotaFilme().equals(that.getNotaFilme());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdFilme(), getNomeFilme(), getNomeDiretor(), getAnoFilme(), getNotaFilme());
    }
}

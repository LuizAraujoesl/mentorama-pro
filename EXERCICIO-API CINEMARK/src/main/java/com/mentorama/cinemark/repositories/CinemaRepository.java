package com.mentorama.cinemark.repositories;

import com.mentorama.cinemark.entities.FilmesCinemark;
import com.mentorama.cinemark.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CinemaRepository{

    private  final List<FilmesCinemark> film;

    @Autowired
    CinemaService cinemaService;


    //construtor Arraylist
    public CinemaRepository() {
       this.film = new ArrayList<>();
    }

    // todos filmes
    public  List<FilmesCinemark> allfilms(){return film;}


    //filtra por nome
    public  List<FilmesCinemark> filmeForName(final  String filme){
        return  film.stream()
                .filter(f -> f.getAnoFilme().contains(filme))
                .collect(Collectors.toList());
    }

    //adiciona filmes
    public void addfilms(FilmesCinemark film){

        String nome = "nome";
        String diretor = "diretor";
        String  ano = "ano";
        for (int i = 0; i < this.film.size(); i++) {
            nome =  this.film.get(i).getNomeFilme();
            diretor = this.film.get(i).getNomeDiretor();
            ano = this.film.get(i).getAnoFilme();
        }
        if ((film.getNomeFilme().equals(nome))&&(film.getNomeDiretor().equals(diretor))&&(film.getAnoFilme().equals(ano))){
            getFilm();
            System.out.println("!!!!!!!!!!!!!!! FILME REPETIDO !!!!!!!!!!!!!!!!!");
        }else {
            System.out.println("******** FILME ADICIONADO COM SUCESSO ********");
            this.film.add(film);
        }

    }

    // tamanho ArrayList
    public  Integer count(){
        return  film.size();
    }

    //filmes por ID
    public FilmesCinemark filmporId(@PathVariable("id") Integer id){
        return this.film.stream()
                .filter(f -> f.getIdFilme().equals(id))
                .findFirst()
                .orElse(null);
    }

    //faz update dos filmes
    public ResponseEntity update(@RequestBody final  FilmesCinemark filme){
        this.film.stream()
                .filter(f -> f.getIdFilme().equals(filme.getIdFilme()))
                .forEach(f -> f.setNomeFilme(filme.getNomeFilme()));


        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    public  ResponseEntity delete(@PathVariable("id") Integer id){
        film.removeIf(f -> f.getIdFilme().equals(id));
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    public void getFilm() {
        String nome = "nome";
        String diretor = "diretor";
        String  ano = "ano";
        for (int i = 0; i < this.film.size(); i++) {
         nome =  this.film.get(i).getNomeFilme();
         diretor = this.film.get(i).getNomeDiretor();
         ano = this.film.get(i).getNomeDiretor();

        }
        System.out.println(nome + " | " + diretor + " | " + ano);
    }


}

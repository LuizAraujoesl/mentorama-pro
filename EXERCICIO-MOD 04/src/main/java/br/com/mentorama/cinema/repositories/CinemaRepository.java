package br.com.mentorama.cinema.repositories;


import br.com.mentorama.cinema.entities.Filmes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class CinemaRepository {

    // lista filmes
    private final List<Filmes> filmes;



    // construtor  para lista de filmes
    public CinemaRepository() {
        this.filmes = new ArrayList<>();
    }


    // metodo pesquizar todos os filmes
    public List<Filmes> filmeAll() {
        return filmes;
    }



   // metodo pesquizar filmes.
    public List<Filmes> filmeNome(final String filme) {
        return filmes.stream()
                .filter(msg -> msg.getFilmeNome().contains(filme))
                .collect(Collectors.toList());
    }



    // adiciona filmes a lista
    public void add(Filmes filmes) {
        this.filmes.add(filmes);
    }

    // conta filmes da lista
    public int count() {
        return filmes.size();
    }

    // filtra por id a lista
    public Filmes filmePorId(@PathVariable("id") Integer id) {
        return  this.filmes.stream()
                .filter(msg -> msg.getFilmeId().equals(id))
                .findFirst()
                .orElse(null);
    }// fim findById


    // faz update da filme
    public ResponseEntity update(@RequestBody final Filmes filmes) {
        this.filmes.stream().filter(msg -> msg.getFilmeId().equals(filmes.getFilmeId()))
                .forEach(msg -> msg.setFilmeNome(filmes.getFilmeNome()));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }// fim update


    // deleta filme
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        filmes.removeIf(msg -> msg.getFilmeId().equals(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }// fim delete


    public List<Filmes> getFilmes() {
        return filmes;
    }


}

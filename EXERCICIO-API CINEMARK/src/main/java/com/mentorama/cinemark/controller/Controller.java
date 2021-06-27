package com.mentorama.cinemark.controller;

import com.mentorama.cinemark.entities.FilmesCinemark;
import com.mentorama.cinemark.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class Controller  {

    private  final List<FilmesCinemark> film;


    @Autowired
    private CinemaService cinemaService;

    public Controller() {
        this.film = new ArrayList<>();
    }


    @GetMapping
    public List<FilmesCinemark>  todosFilmes(@RequestParam(required = false) String film){
        return cinemaService.allFilms(film);
    }

    @GetMapping("/{id}")
    public FilmesCinemark  filmesPorId(@PathVariable("id") Integer id){
        return cinemaService.filmePorId(id);
    }

    @PostMapping
    public ResponseEntity<Integer> addFilme(@RequestBody  final FilmesCinemark film){
        ResponseEntity<Integer> id = cinemaService.addFilms(film);
        return  new ResponseEntity<>(film.getIdFilme(), HttpStatus.CREATED);
    }

    @PutMapping
    public  ResponseEntity alterarFilme(@RequestBody final FilmesCinemark film){
        cinemaService.updadeFilme(film);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagar(@PathVariable("id") Integer id){
        cinemaService.deleteFilme(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);

    }

}

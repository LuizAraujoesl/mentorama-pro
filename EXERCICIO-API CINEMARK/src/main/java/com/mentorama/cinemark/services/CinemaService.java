package com.mentorama.cinemark.services;


import com.mentorama.cinemark.controller.Controller;
import com.mentorama.cinemark.entities.FilmesCinemark;
import com.mentorama.cinemark.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Service
public class CinemaService  {

    private  final List<FilmesCinemark> film;


    @Autowired
    private CinemaRepository cinemaRespository;

    FilmesCinemark filme;


    public CinemaService() {
        this.film = new ArrayList<>();
    }

    public List<FilmesCinemark> allFilms(String filme){
        if(filme != null){
            return  cinemaRespository.filmeForName(filme);
        }
        return  cinemaRespository.allfilms();
    }// allFilms



    // Passas dados para adicionar filme no cinenemaRepository
    public ResponseEntity<Integer> addFilms( @RequestBody FilmesCinemark film){
        if(film.getIdFilme() == null && film.getNotaFilme() <= 5){
            film.setIdFilme(cinemaRespository.count() + 1);
            cinemaRespository.addfilms(film);
        }else {
            System.out.println("Sua Nota deve ser até 5 tente novamente");
        }
        return  new ResponseEntity<>(film.getIdFilme(), HttpStatus.CREATED);
    }

    //retorna filme por ID
    public FilmesCinemark filmePorId(@PathVariable("id") Integer id){
        cinemaRespository.filmporId(id);
        return null;
    }

    //faz update do filme atraves do cinemaRepository
    public void  updadeFilme(final  FilmesCinemark filme){
        cinemaRespository.update((filme));
    }

    //deleta filme atraves do cinemaRepository
    public void  deleteFilme(Integer id){
        cinemaRespository.delete(id);
    }




}

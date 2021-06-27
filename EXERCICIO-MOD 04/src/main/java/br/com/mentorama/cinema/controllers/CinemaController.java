package br.com.mentorama.cinema.controllers;



import br.com.mentorama.cinema.entities.Filmes;
import br.com.mentorama.cinema.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/filme")
public class CinemaController {

    private final List<Filmes> filmes;



    // faz a ingecao de dependencia autmatica
    @Autowired
    private CinemaService cinemaService;

    // construtor da lista
    public CinemaController() {
        this.filmes = new ArrayList<>();
    }

    // mapeamento por nome lista dependendo da class service
    @GetMapping
    public List<Filmes> findAll(@RequestParam(required = false) String menssage){
        return cinemaService.filmeAll(menssage);
    }

    // mapeamento por id  lista dependendo da class service
    @GetMapping("/{id}")
    public Filmes findById(@PathVariable("id") Integer id){
        return cinemaService.filmePorId(id);
    }

    // mapeamento para add por id  lista dependendo da class service
    @PostMapping
    public ResponseEntity<Integer>add(@RequestBody final Filmes filmes){
        ResponseEntity<Integer> id = cinemaService.add(filmes);
        return  new ResponseEntity<>(filmes.getFilmeId(), HttpStatus.CREATED);
    }

    // mapeamento para alterar por id  lista dependendo da class service
    @PutMapping
    public ResponseEntity update(@RequestBody final Filmes filmes){
        cinemaService.update(filmes);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    // mapeamento para deletar por id  lista dependendo da class service
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        cinemaService.delete(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}


package br.com.mentorama.cinema.services;


import br.com.mentorama.cinema.controllers.CinemaController;
import br.com.mentorama.cinema.entities.Filmes;
import br.com.mentorama.cinema.repositories.CinemaRepository;
import br.com.mentorama.cinema.repositories.ICompareTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CinemaService {

    // injecáo de dependencia automatica
    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private CinemaController cinemaController;


    //  recebe e verifica obejeto filme nao e null da class CinemaRepository
    public List<Filmes> filmeAll(String filme) {
        if (filme != null) {
            return cinemaRepository.filmeNome(filme);
        }
        return cinemaRepository.filmeAll();
    }// fim findAll


    // recebe add mensagem da class CinemaRepository
    public ResponseEntity<Integer> add(@RequestBody Filmes filme) {



      if (filme.getFilmeId() == null) {
            filme.setFilmeId(cinemaRepository.count() + 1);
      }

        cinemaRepository.add(filme);
        return new ResponseEntity<>(filme.getFilmeId(), HttpStatus.CREATED);
    }// fim add


    // recebe menssagem por id da class AloMundoRepository
    public Filmes filmePorId(@PathVariable("id") Integer id) {
        cinemaRepository.filmePorId(id);
        return null;
    }// fim findById


    // recebe  menssagem  para update da class AloMundoRepository
    public void update(final Filmes filmes) {
        cinemaRepository.update(filmes);
    }// fim update

    //recebe  id para deletar msg da class AloMundoRepository
    public void delete(Integer id) {
        cinemaRepository.delete(id);
    }// fim delete




}// fim classe

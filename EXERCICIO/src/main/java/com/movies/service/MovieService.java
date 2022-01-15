package com.movies.service;

import com.movies.config.JmsErrorHandler;
import com.movies.model.Movie;
import com.movies.model.User;
import com.movies.repository.MovieRepository;
import com.movies.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class MovieService {


    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    // Service retorna todos Movies
    public List<Movie> listAllMovies() {
        return this.movieRepository.findAll();
    }

    // Fica observando Topcs pra Salvar Usuario
    @JmsListener(destination = "saveTopc", containerFactory = "topcListenerFactory")
    public void saveFilmeAndVote(Movie movie) {
        User user = this.userRepository.findById(movie.getUserId().getId()).get();
            movie.setUserId(user);
            movie.getNameMovie().toLowerCase(Locale.ROOT);
            List<Movie> search =  listAllMovies();
            if(!search.isEmpty()){
              Movie m = this.movieRepository.findMovieByNameMovie(movie.getNameMovie());
              if(m == null){
                  this.movieRepository.save(movie);
              }else if(m.getUserId().getId().equals(movie.getUserId().getId())){
                  throw new RuntimeException("Usuario nao pode votar movie duas vezes");
              }else{
                  this.movieRepository.save(movie);
              }
            }
            if(search.isEmpty()){
                this.movieRepository.save(movie);
            }

        System.out.println("Menssagem recebida salva com sucesso");
    }

    // Fica observando Queue para Deletar
    @JmsListener(destination = "deleteTopc", containerFactory = "topcListenerFactory")
    public void deleteMovies(Movie movie) {
        this.movieRepository.deleteById(movie.getId());
        System.out.println("Menssagem recebida Deletada com sucesso");
    }
}

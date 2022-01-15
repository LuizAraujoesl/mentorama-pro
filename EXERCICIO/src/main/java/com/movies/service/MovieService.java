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

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);

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
        User user = this.userRepository.findById(movie.getUserId().getId()).orElseThrow(
                ()->  new RuntimeException("Usuario Nao encontrado")
        );
        LOGGER.info("Menssagem recebida salva com sucesso");
        Movie search = this.movieRepository.findById(movie.getId()).orElseThrow(
                ()-> new RuntimeException("Movie nao encontrado")
        );
        if (movie.getNameMovie().equals(search.getNameMovie())
                && search.getUserId().getId().equals(movie.getUserId().getId())){
            new JmsErrorHandler();
        } else {
            movie.setUserId(user);
            movie.getNameMovie().toLowerCase(Locale.ROOT);
            this.movieRepository.save(movie);
        }
    }

    // Fica observando Queue para Deletar
    @JmsListener(destination = "deleteTopc", containerFactory = "topcListenerFactory")
    public void deleteMovies(Movie movie) {
        LOGGER.info("Menssagem recebida apagada com sucesso");
        this.movieRepository.deleteById(movie.getId());
    }
}

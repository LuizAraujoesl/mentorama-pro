package com.movies.service;

import com.movies.config.JmsErrorHandler;
import com.movies.model.Movie;
import com.movies.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class MovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    private MovieRepository movieRepository;

    public Flux<List<Movie>> listAllMovies(){
        return this.movieRepository.findAll().buffer();
    }

    @JmsListener(destination = "topc.mailbox", concurrency = "jmsFactoryTopc")
    public void saveFilmeAndVote( Movie movie){
        LOGGER.info("Menssagem recebida salva com sucesso");
        Movie search = this.movieRepository.findByUserId(movie.getId());
        if(movie.getNameMovie().equals(search.getNameMovie())){
          new JmsErrorHandler();
        }else{
            this.movieRepository.save(movie);
        }
    }

    @JmsListener(destination = "topc.mailbox", concurrency = "jmsFactoryTopc")
    public Mono<Movie> deleteMovies(String name){
        LOGGER.info("Menssagem recebida apagada com sucesso");
        return this.movieRepository.deleteMovieByNameMovie(name).single();
    }
}

package com.movies.service;

import com.movies.config.JMSConfiguration;
import com.movies.config.JmsErrorHandler;
import com.movies.model.Movie;
import com.movies.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> listAllMovies(){
        return this.movieRepository.findAll();
    }

    @JmsListener(destination = "topc.mailbox", containerFactory = "topcListenerFactory")
    public void saveFilmeAndVote( Movie movie){
        LOGGER.info("Menssagem recebida salva com sucesso");
        Optional<Movie> search = this.movieRepository.findById(movie.getId());
        if(search.isEmpty()){
          new JmsErrorHandler();
        }else{
            this.movieRepository.save(movie);
        }
    }

    @JmsListener(destination = "topc.mailbox", containerFactory = "topcListenerFactory")
    public void deleteMovies(String id){
        LOGGER.info("Menssagem recebida apagada com sucesso");
        this.movieRepository.deleteById(id);
    }
}

package com.movies.controller;

import com.movies.model.Movie;
import com.movies.model.User;
import com.movies.repository.UserRepository;
import com.movies.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> listAllMovies(){
        return this.movieService.listAllMovies();
    }

    // Fica observando Queue pra Salvar Usuario
    @PostMapping("/new")
    public ResponseEntity voteMovies(@RequestBody Movie movie){
        jmsTemplate.convertAndSend("saveTopc", movie);
        LOGGER.info("Post-> movie --> Menssagem enviada para Topc");
        return ResponseEntity.ok().build();
    }

    // Fica observando Queue pra Deletar Usuario
    @DeleteMapping("/delete")
    public ResponseEntity deleteMovies(@RequestBody  Movie movie){
        jmsTemplate.convertAndSend("deleteMailbox", movie);
        LOGGER.info("Delete-> movie --> Menssagem enviada para Topc");
        return ResponseEntity.ok().build();
    }
}

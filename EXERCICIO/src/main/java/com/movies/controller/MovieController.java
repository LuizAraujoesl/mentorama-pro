package com.movies.controller;

import com.movies.model.Movie;
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

    @PostMapping("/new")
    public ResponseEntity voteMovies(@RequestBody Movie movie){
        LOGGER.info("Post-> movie --> Menssagem enviada para Topc");
        jmsTemplate.convertAndSend("topc.mailbox", movie);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{name}")
    public ResponseEntity deleteMovies(@RequestParam  String name){
       LOGGER.info("Delete-> movie --> Menssagem enviada para Topc");
        jmsTemplate.convertAndSend("topc.mailbox", name);
        return ResponseEntity.ok().build();
    }
}

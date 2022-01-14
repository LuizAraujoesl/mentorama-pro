package com.movies.repository;

import com.movies.model.Movie;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MovieRepository extends ReactiveCrudRepository<Movie, String> {
    Movie findByUserId(final String id);
    Mono<Movie> findByNameMovie(final String nameMovie);
    Mono<Movie> deleteMovieByNameMovie(final String nameMovie);
}

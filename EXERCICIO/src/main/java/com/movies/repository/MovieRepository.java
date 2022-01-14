package com.movies.repository;

import com.movies.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
}

package com.travelworks.service;

import com.travelworks.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TravelRespository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class TravelService {


    @Autowired
    private TravelRespository respository;

    public CompletableFuture<List<Persona>> findAll(){
        return this.respository.findAllBy();
    }

    public CompletableFuture<Optional<Persona>> findById(Long id){
        return this.respository.findOneById(id);
    }

    public CompletableFuture<Persona> savePersona(Persona persona){
        return CompletableFuture.completedFuture(this.respository.save(persona));
    }

    public CompletableFuture<Persona> deletePersona(Persona persona){
        this.respository.delete(persona);
        return CompletableFuture.completedFuture(persona);
    }
}

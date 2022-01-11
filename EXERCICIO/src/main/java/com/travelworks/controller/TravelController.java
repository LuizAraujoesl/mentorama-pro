package com.travelworks.controller;

import com.travelworks.model.Persona;
import com.travelworks.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/persona")
@Async
public class TravelController {

    @Autowired
    private TravelService travelService;

    @GetMapping
    public ResponseEntity<CompletableFuture<List<Persona>>> findAll(){
        System.out.println("Controller Thread findAll: " + Thread.currentThread().getName());
       return ResponseEntity.status(HttpStatus.OK).body(this.travelService.findAll());
    }

    @GetMapping("/{id}")
    public CompletableFuture<Optional<Persona>> findById(@RequestBody Long id){
        System.out.println("Controller Thread findById: " + Thread.currentThread().getName());
        return this.travelService.findById(id);
    }

    @PostMapping("/add")
    public CompletableFuture<Persona> savePersona(@RequestBody Persona persona){
        System.out.println("Controller Thread savePersona: " + Thread.currentThread().getName());
        return this.travelService.savePersona(persona);
    }

    @DeleteMapping("/delete")
    public CompletableFuture<Persona> deletePersona(@RequestBody Persona persona){
        System.out.println("Controller Thread deletePersona: " + Thread.currentThread().getName());
        return this.travelService.deletePersona(persona);
    }
}

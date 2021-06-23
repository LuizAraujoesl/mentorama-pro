package br.com.mentorama.aloMundo.controllers;



import br.com.mentorama.aloMundo.entities.Menssage;
import br.com.mentorama.aloMundo.services.AloMundoService;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/olamundo")
public class AloMundoController {

    // recebe lista msg
    private final List<Menssage>menssages;

    // faz a ingecao de dependencia autmatica
    @Autowired
    private AloMundoService olaMundoService;

    // construtor da lista
    public AloMundoController() {
        this.menssages = new ArrayList<>();
    }

    // mapeamento por nome lista dependendo da class service
    @GetMapping
    public List<Menssage> findAll(@RequestParam(required = false) String menssage){
        return olaMundoService.findAll(menssage);
    }

    // mapeamento por id  lista dependendo da class service
    @GetMapping("/{id}")
    public Message findById(@PathVariable("id") Integer id){
        return olaMundoService.findById(id);
    }

    // mapeamento para add por id  lista dependendo da class service
    @PostMapping
    public ResponseEntity<Integer>add(@RequestBody final Menssage menssage){
        ResponseEntity<Integer> id = olaMundoService.add(menssage);
        return  new ResponseEntity<>(menssage.getId(), HttpStatus.CREATED);
    }

    // mapeamento para alterar por id  lista dependendo da class service
    @PutMapping
    public ResponseEntity update(@RequestBody final Menssage menssage){
        olaMundoService.update(menssage);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    // mapeamento para deletar por id  lista dependendo da class service
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        olaMundoService.delete(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}


package br.com.mentorama.aloMundo.controllers;

import br.com.mentorama.aloMundo.entities.Cesta;
import br.com.mentorama.aloMundo.entities.Produtos;
import br.com.mentorama.aloMundo.services.CestaService;
import br.com.mentorama.aloMundo.services.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/car")
public class CarrinhoController {

    @Autowired
    private ProdutosService produtosService;
    @Autowired
    private CestaService cestaService;

    @GetMapping
    public ResponseEntity<Cesta> listar(){
      return   new ResponseEntity(cestaService.listarCar(), HttpStatus.OK);
    }


    @PostMapping("/{id}")
    public ResponseEntity<Produtos>add(@PathVariable("id") Integer id){
        return  new ResponseEntity(cestaService.addProduto(id), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        return  new ResponseEntity(cestaService.deleteProduto(id), HttpStatus.OK);
    }
}


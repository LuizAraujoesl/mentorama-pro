package br.com.mentorama.aloMundo.controllers;

import br.com.mentorama.aloMundo.entities.Produtos;
import br.com.mentorama.aloMundo.services.CarrinhoService;
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
    private CarrinhoService carrinhoService;

    @GetMapping
    public ResponseEntity<List<Produtos>> listar(){
      return   new ResponseEntity(carrinhoService.listarCar(), HttpStatus.OK);
    }


    @PostMapping("/{id}")
    public ResponseEntity<Produtos>add(@PathVariable("id") Integer id){
        return  new ResponseEntity(carrinhoService.addProduto(id), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        return  new ResponseEntity(carrinhoService.deleteProduto(id), HttpStatus.OK);
    }
}


package br.com.mentorama.aloMundo.controllers;

import br.com.mentorama.aloMundo.entities.Produtos;
import br.com.mentorama.aloMundo.services.ProdutosService;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/loja")
public class ProdutosController {

    @Autowired
    private ProdutosService produtosService;

    @GetMapping("/produtos")
    public ResponseEntity<List<Produtos>> listarProdutos(){
      return   new ResponseEntity(produtosService.findAll(), HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Produtos>addPRodutos(@RequestBody final Produtos produtos){
        return  new ResponseEntity(produtosService.addProduto(produtos), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateAtualizar(@RequestBody final Produtos produtos){
        return  new ResponseEntity(produtosService.updateProduto(produtos), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarProdutos(@PathVariable("id") Integer id){
        return  new ResponseEntity(produtosService.deleteProduto(id), HttpStatus.OK);
    }
}


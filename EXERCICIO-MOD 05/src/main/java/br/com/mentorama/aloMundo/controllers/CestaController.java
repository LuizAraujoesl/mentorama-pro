package br.com.mentorama.aloMundo.controllers;

import br.com.mentorama.aloMundo.entities.Cesta;
import br.com.mentorama.aloMundo.entities.Produtos;
import br.com.mentorama.aloMundo.services.CestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cesta")
public class CestaController {

    @Autowired
    private CestaService cestaService;

    // Listar produtos cesta de compras
    @GetMapping
    public ResponseEntity<Cesta> listar(){
      return   new ResponseEntity(cestaService.listarCesta(), HttpStatus.OK);
    }

    // Colorar produto na cesta
    @PostMapping("/{id}")
    public ResponseEntity<Produtos>add(@PathVariable("id") Integer id){
        return  new ResponseEntity(cestaService.addProduto(id), HttpStatus.CREATED);
    }

    // Remover produtos na Cesta
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        return  new ResponseEntity(cestaService.deleteProduto(id), HttpStatus.OK);
    }
}


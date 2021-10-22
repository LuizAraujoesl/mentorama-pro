package br.com.mentorama.aloMundo.services;


import br.com.mentorama.aloMundo.entities.Cesta;
import br.com.mentorama.aloMundo.entities.ItensCesta;
import br.com.mentorama.aloMundo.entities.Produtos;
import br.com.mentorama.aloMundo.repositories.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CestaService {

    @Autowired
    private  ProdutosRepository produtosRepository;

    // Lista Cesta de Compras
    public Cesta listarCesta() {
        return this.produtosRepository.getCestaCompras();
    }

    // Adiciona produtos a cesta
    public List<ItensCesta> addProduto(@RequestBody Integer id) {
        Produtos produtos = produtosRepository.getProdutos().stream()
                .filter(p -> p.getId().equals(id)).findFirst().get();
        produtosRepository.setCestaCompras(produtos);
        return  this.produtosRepository.getCestaCompras().getItemCarrinho();
    }

    // Deleta produtos da Cesta
    public ResponseEntity deleteProduto(@PathVariable("id") Integer id) {
        produtosRepository.deletItem(id);
        return  new ResponseEntity(listarCesta(),HttpStatus.OK);
    }
    

}// fim classe

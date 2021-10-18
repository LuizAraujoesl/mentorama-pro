package br.com.mentorama.aloMundo.services;


import br.com.mentorama.aloMundo.entities.ProdutosSelecionados;
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
public class CarrinhoService {

    @Autowired
    private  ProdutosRepository produtosRepository;

    public List<ProdutosSelecionados> listarCar() {
        return produtosRepository.getSelectProd();
    }

    public List<ProdutosSelecionados> addProduto(@RequestBody Integer id) {
        Produtos produtos = produtosRepository.getProdutos().stream()
                .filter(p -> p.getId().equals(id)).findFirst().get();
        produtosRepository.setProdutosSelect(produtos);
        return  produtosRepository.getSelectProd();
    }

    public ResponseEntity deleteProduto(@PathVariable("id") Integer id) {
        produtosRepository.deletCompras(id);
        return  new ResponseEntity(produtosRepository.getSelectProd(),HttpStatus.OK);
    }
    

}// fim classe

package br.com.mentorama.aloMundo.services;


import br.com.mentorama.aloMundo.entities.Produtos;
import br.com.mentorama.aloMundo.repositories.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutosService {

    @Autowired
    private  ProdutosRepository produtosRepository;


    public List<Produtos> findAll() {
        List<Produtos> lojaVirtual =  this.produtosRepository.getProdutos();
        return lojaVirtual;
    }

    public Produtos findById(@PathVariable("id") Integer id) {
        Produtos produtos = produtosRepository.getProdutos().stream()
                .filter(p -> p.getId().equals(id)).findFirst().get();
        return produtos;
    }


    public Produtos updateProduto(@RequestBody final Produtos produtos) {
        produtosRepository.setProdutos(produtos);

        Produtos pesquisar = produtosRepository.getProdutos().stream()
                .filter(p -> p.getId().equals(produtos.getId())).findAny().get();
        return pesquisar;
    }

    public Produtos addProduto(@RequestBody final Produtos produtos) {
        produtosRepository.setProdutos(produtos);

        Produtos pesquisar = produtosRepository.getProdutos().stream()
                .filter(p -> p.getId().equals(produtos.getId())).findAny().get();
        return pesquisar;
    }

    public ResponseEntity deleteProduto(@PathVariable("id") Integer id) {
        produtosRepository.deletProdutos(id);
        return  new ResponseEntity(HttpStatus.OK);
    }


}// fim classe

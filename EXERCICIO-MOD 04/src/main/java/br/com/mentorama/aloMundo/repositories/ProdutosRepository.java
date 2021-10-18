package br.com.mentorama.aloMundo.repositories;


import br.com.mentorama.aloMundo.entities.Cesta;
import br.com.mentorama.aloMundo.entities.ProdutosSelecionados;
import br.com.mentorama.aloMundo.entities.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutosRepository {

     private  List<Produtos> produtos;
     @Autowired
     private ProdutosSelecionados produtosSelect;
     private List<ProdutosSelecionados> selectProd;

     double descountUm = 10.0;
     double descountDois = 5.0;

    public ProdutosRepository() {
        this.selectProd = new ArrayList<ProdutosSelecionados>();
        // add Produtos
        this.produtos = new ArrayList<>();
        Produtos celular =  new Produtos(1, "eletrônicos", "celular_xiaomi", 999.0, 7);
        Produtos foneOuvido =  new Produtos(2, "eletrônicos","fone_xiaomi", 425.0, 5);
        Produtos notebook =  new Produtos(3, "eletrônicos","notebook_xiaomi", 3000.0, 6);
        produtos.add(celular);
        produtos.add(foneOuvido);
        produtos.add(notebook);
        Produtos sofa =  new Produtos(4, "moveis", "sofa_italia",555.0, 2);
        Produtos hack =  new Produtos(5, "moveis", "hack_italia",350.0, 1);
        Produtos cozinha =  new Produtos(6, "moveis", "cozinha_italia",1200.0, 3);
        produtos.add(sofa);
        produtos.add(hack);
        produtos.add(cozinha);

    }

    public List<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        int i = 0;
        for ( Produtos p: this.produtos) {
            if (p.getId().equals(produtos.getId())){
                this.produtos.set(i, produtos);
            }
            i++;
        }
        if (produtos != null){
            this.produtos.add(produtos);
        }
    }

    public void deletProdutos(Integer id) {
        int i = 0;
        for ( Produtos p: this.produtos) {
            if (p.getId().equals(id)){
                this.produtos.remove(i);
                break;
            }
            i++;
        }
    }

    public ProdutosSelecionados getProdutosSelect() {
        return produtosSelect;
    }

    public void setProdutosSelect(Produtos produtos) {
        Integer contCarId = 1;
        if(this.produtosSelect.getId() == null){
            this.produtosSelect.setId(contCarId);
        }
        this.produtosSelect.setProdutos(produtos);

        for ( Produtos p: this.produtos) {
            p.setAmount(p.getAmount()-1);
        }

        if(produtos.getPrice() >= 700){
            this.produtosSelect.setDiscount(descountUm);
        }else if(produtos.getPrice() <= 700){
            this.produtosSelect.setDiscount(descountDois);
        }
        contCarId++;

        this.selectProd.add(produtosSelect);
    }

    public void deletCompras(Integer id){
        int i = 0;
        for ( ProdutosSelecionados p: this.selectProd) {
            if (p.getId().equals(id)){
                this.selectProd.remove(i);
                break;
            }
            i++;
        }
    }

    public List<ProdutosSelecionados> getSelectProd() {
        return selectProd;
    }

    public List<ProdutosSelecionados> setCarrinho (ProdutosSelecionados produtosSelecionados) {
        selectProd.add(produtosSelecionados);
        return selectProd;
    }
}

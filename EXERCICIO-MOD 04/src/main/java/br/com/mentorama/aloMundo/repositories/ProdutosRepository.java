package br.com.mentorama.aloMundo.repositories;


import br.com.mentorama.aloMundo.entities.Cesta;
import br.com.mentorama.aloMundo.entities.ItemCarrinho;
import br.com.mentorama.aloMundo.entities.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutosRepository {
    @Autowired
    private Cesta cesta;

    private List<Produtos> produtos;
    Cesta cestaCompras = new Cesta();


    public ProdutosRepository() {
        // add Produtos
        this.produtos = new ArrayList<>();
        Produtos celular = new Produtos(1, "eletrônicos", "celular_xiaomi", 999.0, 7);
        Produtos foneOuvido = new Produtos(2, "eletrônicos", "fone_xiaomi", 425.0, 5);
        Produtos notebook = new Produtos(3, "eletrônicos", "notebook_xiaomi", 3000.0, 6);
        produtos.add(celular);
        produtos.add(foneOuvido);
        produtos.add(notebook);
        Produtos sofa = new Produtos(4, "moveis", "sofa_italia", 555.0, 2);
        Produtos hack = new Produtos(5, "moveis", "hack_italia", 350.0, 1);
        Produtos cozinha = new Produtos(6, "moveis", "cozinha_italia", 1200.0, 3);
        produtos.add(sofa);
        produtos.add(hack);
        produtos.add(cozinha);

    }

    public List<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        int i = 0;
        for (Produtos p : this.produtos) {
            if (p.getId().equals(produtos.getId())) {
                this.produtos.set(i, produtos);
            }
            i++;
        }
        if (produtos != null) {
            this.produtos.add(produtos);
        }
    }

    public void deletProdutos(Integer id) {
        int i = 0;
        for (Produtos p : this.produtos) {
            if (p.getId().equals(id)) {
                this.produtos.remove(i);
                break;
            }
            i++;
        }
    }


    public void setCestaCompras(Produtos produtos) {

        ItemCarrinho item = new ItemCarrinho();
        boolean estoque;
        item.setId(produtos.getId());
        item.setName(produtos.getName());
        item.setPrice(produtos.getPrice());

        for (Produtos p : this.produtos) {
            if (p.getName().equals(item.getName())) {
                if (p.getAmount() > 0) {
                    this.cesta.setItemCarrinho(item);
                    this.cestaCompras.setItemCarrinho(item);
                    double soma = this.cestaCompras.getItemCarrinho().stream()
                            .mapToDouble(d -> d.getPrice()).sum();
                    cestaCompras.setTotal(soma);
                    double descountUm = (cestaCompras.getTotal() * 10.0) / 100;
                    double descountDois = (cestaCompras.getTotal() * 5.0) / 100;

                    if (soma > 500) {
                        cestaCompras.setDescount(descountUm);
                        this.cesta.setTotal(soma - descountUm);
                    } else if (soma < 500) {
                        cestaCompras.setDescount(descountDois);
                        cestaCompras.setTotal(soma - descountDois);
                    }


                    p.setAmount(p.getAmount() - 1);
                }
                System.out.println("****** Produto acabou *******");
                break;


            }

        }

    }

    public void deletItem(Integer id) {
        int i = 0;
        for (ItemCarrinho item : cestaCompras.getItemCarrinho()) {
            if (item.getId().equals(id)) {
                cestaCompras.getItemCarrinho().remove(i);

                for (Produtos p: this.produtos){
                    if (p.getId() == id){
                        int x = 1;
                        p.setAmount(p.getAmount() + x);
                        break;
                    }
                }
                break;
            }
            i++;
        }
    }

    public Cesta getCestaCompras() {
        return cestaCompras;
    }

}

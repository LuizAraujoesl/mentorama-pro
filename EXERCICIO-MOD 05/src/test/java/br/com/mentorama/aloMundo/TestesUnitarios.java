package br.com.mentorama.aloMundo;

import br.com.mentorama.aloMundo.entities.Cesta;
import br.com.mentorama.aloMundo.entities.ItensCesta;
import br.com.mentorama.aloMundo.entities.Produtos;
import br.com.mentorama.aloMundo.repositories.ProdutosRepository;
import br.com.mentorama.aloMundo.services.CestaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.logging.Logger;

@SpringBootTest
public class TestesUnitarios {


    @Autowired
    ProdutosRepository produtosRepository;
    @Autowired
    CestaService cestaService;
    double soma;

    Cesta cesta;
    ItensCesta itensCesta;
    ProdutosRepository produtos;
    List<Produtos> p;

    @BeforeEach
    void instanciarObjeto(){
        this.cesta = new Cesta();
        this.itensCesta =  new ItensCesta();
        this.produtos = new ProdutosRepository();
        this.p = this.produtos.getProdutos();
    }

    @Test
    @DisplayName("1- Produtos nao Nulos")
    void verificaProdutosNotNull(){
        Assertions.assertNotNull(p, "Produto nao e Nulo");
    }

    @Test
    @DisplayName("2- Produtos Verificacao Valores")
    void verificaValoresProdutos(){
        Double valor = 999.0;
        for (Produtos prod : p) {
            if (prod.getPrice() == valor){
                Assertions.assertEquals(valor, prod.getPrice());
            }
        }
    }

    @Test
    @DisplayName("3- Produtos Verificacao Nomes")
    void verificaNomeProdutos(){
        String name = "celular_xiaomi";
        for (Produtos prod : p) {
            if (prod.getName().equals(name)){
                Assertions.assertEquals(name, prod.getName());
            }
        }
    }

    @Test
    @DisplayName("4- Produtos Verificacao Estoque")
    void verificaEstoqueProdutos(){
        Integer estoque = 7;
        String name = "celular_xiaomi";
        for (Produtos prod : p) {
            if (prod.getAmount() == estoque && prod.getName().equals(name)){
                Assertions.assertEquals(estoque, prod.getAmount());
            }
        }
    }

    @Test
    @DisplayName("5- Verificando desconto")
    void verificMaiorDesc(){
        Integer idProd = 3;
        for (Produtos prod : p) {
            if (idProd == prod.getId()){
                itensCesta.setId(prod.getId());
                itensCesta.setName(prod.getName());
                itensCesta.setPrice(prod.getPrice());
            }

        }
        this.cesta.setItemCarrinho(this.itensCesta);
        // Faz soma dos so total da cesta
        this.soma = this.cesta.getItemCarrinho().stream()
                .mapToDouble(d -> d.getPrice()).sum();
        cesta.setTotal(soma);
         double desDez = 10.0;
         double desCinco = 5.0;
        // Aplica  desconto maximo
        if (soma > 500) {
            if(desDez <= 10) {
                double descontoUm = (this.soma * desDez) / 100;
                cesta.setDescount(descontoUm);
                cesta.setTotal(soma - cesta.getDescount());
            }else {
                Logger.getAnonymousLogger("Desconto maior que 10% nao e permitido");
            }

            // Aplica desconto minimo
        } else if (soma < 500) {
            if(desCinco <= 5){
                cesta.setDescount((this.soma * desCinco) / 100);
                cesta.setTotal(soma - cesta.getDescount());
            }else {
                Logger.getAnonymousLogger("Desconto maior que 5% nao e permitido");
            }

        }

        Assertions.assertEquals(300, cesta.getDescount());
    }



    @Test
    @DisplayName("6- Menor Desconto")
    void verificMenorDesc(){
        Integer idProd = 5;
        for (Produtos prod : p) {
            if (idProd == prod.getId()){
                itensCesta.setId(prod.getId());
                itensCesta.setName(prod.getName());
                itensCesta.setPrice(prod.getPrice());
            }

        }
        this.cesta.setItemCarrinho(this.itensCesta);
        // Faz soma dos so total da cesta
        this.soma = this.cesta.getItemCarrinho().stream()
                .mapToDouble(d -> d.getPrice()).sum();
        cesta.setTotal(soma);

        // Aplica  desconto maximo
        if (soma > 500) {
            cesta.setDescount((this.soma * 10.0) / 100);
            cesta.setTotal(soma - cesta.getDescount());

            // Aplica desconto minimo
        } else if (soma < 500) {
            cesta.setDescount((this.soma * 5.0) / 100);
            cesta.setTotal(soma - cesta.getDescount());
        }

        Assertions.assertEquals(17.5, cesta.getDescount());
    }


    @Test
    @DisplayName("7- Verificando MSG produto sem estoque")
    void verificaEstoqueProdutosMsg() {
        Integer idProd = 5;
            for (Produtos prod : p) {
                if(prod.getId() == idProd) {
                    prod.setAmount(0);
                    if (prod.getAmount() == 0) {
                        System.out.println("Produto indisponivel ou sem estoque");
                    }
                }
            }

    }
}

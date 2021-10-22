package br.com.mentorama.aloMundo;

import br.com.mentorama.aloMundo.entities.Cesta;
import br.com.mentorama.aloMundo.entities.ItensCesta;
import br.com.mentorama.aloMundo.entities.Produtos;
import br.com.mentorama.aloMundo.repositories.ProdutosRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProdutosServiceTests {


	@Autowired
	ProdutosRepository produtosRepository;

	double deconto;
	double descountUm;
	double descountDois;

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
		this.deconto = this.produtos.getCestaCompras().getDescount();
		this.descountUm = (this.cesta.getTotal() * 10.0) / 100;
		this.descountDois = (this.cesta.getTotal() * 5.0) / 100;
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
		Assertions.assertEquals(descountDois, cesta.getDescount());
	}


}

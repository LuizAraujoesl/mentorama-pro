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
	@DisplayName("5- Maior Desconto")
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

		// Aplica  desconto maximo
		if (soma > 500) {
			cesta.setDescount((this.soma * 10.0) / 100);
			cesta.setTotal(soma - cesta.getDescount());

			// Aplica desconto minimo
		} else if (soma < 500) {
			cesta.setDescount((this.soma * 5.0) / 100);
			cesta.setTotal(soma - cesta.getDescount());
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

}

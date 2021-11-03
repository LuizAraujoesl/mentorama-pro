package br.com.mentorama.aloMundo;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestesIntegracao {
    private  static final String MOCKED_RESULT =
            "   {\n" +
                    "   [\n" +
                    "   {\n" +
                    "   \"id\": 1,\n" +
                    "   \"type\": \"eletrônicos\", \n" +
                    "   \"name\": \"celular_xiaomi\",\n" +
                    "   \"price\": 999.0," +
                    "   \"amount\": 7 \n" +
                    "     } \n"+
                    "     ]\n" +

                    "     }\n";

    private  static WireMockServer wireMockServer =  new WireMockServer(options().port(8081));

    @BeforeAll
    static void berforAll(){
        wireMockServer.start();
    }

    @BeforeEach
    void setUp(){
        wireMockServer.resetAll();
    }


    @Test
    @DisplayName("1-Testando Endpoint loja produtos")
    public void lojaDeProducts(){
        wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/loja/produtos"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(MOCKED_RESULT)));
    }

    @Test
    @DisplayName("2-Testando adicao de produtos na cesta")
    public void cestaAddCompras(){
        wireMockServer.stubFor(WireMock.post(WireMock.urlEqualTo("/loja/cesta"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(MOCKED_RESULT)));
    }

    @Test
    @DisplayName("3-Testando lista de produtos na cesta")
    public void cestaListCompras(){
        wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/loja/cesta"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(MOCKED_RESULT)));
    }

    @Test
    @DisplayName("4-Testando delecao de produtos na cesta")
    public void cestaDeleteCompras(){
        wireMockServer.stubFor(WireMock.delete(WireMock.urlEqualTo("/loja/cesta"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(MOCKED_RESULT)));
    }




    @AfterAll
    void staticAll(){
        wireMockServer.stop();
    }



}

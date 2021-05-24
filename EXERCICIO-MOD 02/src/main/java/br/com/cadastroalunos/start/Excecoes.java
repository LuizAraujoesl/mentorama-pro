package br.com.cadastroalunos.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;


public class Excecoes extends  Exception {

    private   static Logger LOGGER = LoggerFactory.getLogger(Excecoes.class);

    // Contrutor
    public Excecoes() {
        // Error personalizado de Logger
        getLOGGER();

        // repassa mensagem / Status Not_Found
        throw  new RecursoInexstenteExeption();
    }

    // methodo mensagem Logger
    public static Logger getLOGGER() {
        LOGGER.error("************** ERROR 404 -NOT FOUND **************");
        return LOGGER;
    }
}

package br.com.cadastroalunos.start;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class RecursoInexstenteExeption extends RuntimeException{

    @ExceptionHandler({RecursoInexstenteExeption.class})
    public ResponseEntity<String> handle(final  RecursoInexstenteExeption e){
        return  new ResponseEntity<>("RECURSO NÃO ENCONTRADO", HttpStatus.NOT_FOUND);
    }

}

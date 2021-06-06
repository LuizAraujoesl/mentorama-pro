package com.mentorama.exerciciomod03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MensagemController {

    @GetMapping
    public String msg (){
        String mensagem = "Ola mundo!";
        return mensagem;
    }

}

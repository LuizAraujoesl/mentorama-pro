package com.mentorama.exception;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class AlunoService {

    public List<String> buscador(){

        String caminho =  AlunoService.class.getClassLoader()
                .getResource("alunos.txt")
                .getPath().trim();

        try{
            List<String> alunos = Files.readAllLines(Paths.get(caminho));
            return alunos;
        } catch (IOException ioException){

            return Collections.emptyList();

        }


    }
}

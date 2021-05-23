package com.mentorama.excecoes;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AlunoService {

    public void findAll() {
        // recebendo caminho arquivo
        File file = new File("C:\\Users\\Luiz\\Desktop\\MENTORAMA-PRO\\2- EXCEÇÕES\\src\\main\\resources\\alunos.txt");


        //instanciando Scanner
        Scanner sc = null;

        // tratamento errro
        try {

            // lendo arquivo
            sc = new Scanner(file);

            // procurando linhas

            while (sc.hasNextLine()) {

                // imprimindo linhas
                System.out.println(sc.nextLine());
            }// try
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }//cath

        // fechando Scanner
        finally {
            if(sc != null){
                sc.close();
            }//if

        }//finally

    }// findAll

}// class

package com.mentorama.excecoes;


public class ExcecoesApplication {

    public static void main(String[] args) {

        AlunoService alunoService = new AlunoService();
        alunoService.findAll().stream().forEach(System.out::println);
    }

}

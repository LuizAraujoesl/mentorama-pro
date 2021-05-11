package com.mentorama.exception;




public class ExceptionApplication {

    public static void main(String[] args) {

        AlunoService alunoService = new AlunoService();
        alunoService.buscador().stream().forEach(System.out::println);
    }


}

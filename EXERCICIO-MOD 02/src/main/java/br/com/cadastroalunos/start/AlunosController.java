package br.com.cadastroalunos.start;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class AlunosController {

    // atributo
    private List<Alunos> aluno;

    // Construtor
    public AlunosController() {
        this.aluno = new ArrayList<>();

        Alunos aluno1 = new Alunos(1, "Pocahontas", 27);
        Alunos aluno2 = new Alunos(2, "Thais", 18);
        Alunos aluno3 = new Alunos(3, "Juliete", 30);
        Alunos aluno4 = new Alunos(4, "Vitube", 16);
        Alunos aluno5 = new Alunos(5, "Carla Dias", 22);

        this.aluno.add(aluno1);
        this.aluno.add(aluno2);
        this.aluno.add(aluno3);
        this.aluno.add(aluno4);
        this.aluno.add(aluno5);
    }

    public List<Alunos> getAluno() {
        return aluno;
    }

    public void setAluno(List<Alunos> aluno) {
        this.aluno = aluno;
    }
}

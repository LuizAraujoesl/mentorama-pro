package br.com.cadastroalunos.start;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    // lista
    private List<Alunos> aluno;


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


    //Buncando todos os alunos
    //Filtrando por Nome
    //Filtrando por idade
    @GetMapping()
    public List<Alunos> filterName(@RequestParam(required = false) String nome, Integer idade) {
        if (nome != null) {

            return aluno.stream()
                    .filter(msg -> msg.getNome().contains(nome))
                    .collect(Collectors.toList());
        }

        if (idade != null) {
            return aluno.stream()
                    .filter(msg -> msg.getIdade().equals(idade))
                    .collect(Collectors.toList());
        }

        return this.aluno;
    }

    //Filtrando por ID
    @GetMapping("/{id}")
    public List<Alunos> filterID(@PathVariable("id") Integer id) {
        return aluno.stream().filter(msg -> msg.getId().equals(id))
                .collect(Collectors.toList());
    }

    //Postando aluno
    @PostMapping
    public ResponseEntity<Integer> addAluno(@RequestBody Alunos alunos) {

        if (alunos.getId() == null) {
            alunos.setId(aluno.size() + 1);
        }
        aluno.add(alunos);

        return new ResponseEntity<>(alunos.getId(), HttpStatus.CREATED);
    }

    //Alterando Nome e idade Alunos
    @PutMapping
    public ResponseEntity updateAluno(@RequestBody Alunos alunos) {
        aluno.stream().filter(msg -> msg.getId().equals(alunos.getId()))
                .forEach(msg -> msg.setNome(alunos.getNome()));
        aluno.stream().filter(msg -> msg.getId().equals(alunos.getId()))
                .forEach(msg -> msg.setIdade(alunos.getIdade()));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    //Deletando Alunos
    @DeleteMapping("/{id}")
    public ResponseEntity deleteAluno(@PathVariable("id") Integer id) {
        aluno.removeIf(msg -> msg.getId().equals(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}

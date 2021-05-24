package br.com.cadastroalunos.start;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ClientInfoStatus;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class Service {

    AlunosController aluno = new AlunosController();

    /**  ------------------------------Mapeamento de Filto Todos  ----------------------------------------**/

    @GetMapping()
    public List<Alunos> filterTodos()  {
        return this.aluno.getAluno();
    }

    /**  ------------------------------Mapeamento de Filtro por Nome ----------------------------------------**/
    @GetMapping("/nome")
    public List<Alunos> filterName(@RequestParam(required = false) String nome) throws Excecoes  {

        // Cria Lista vazia para receber pesquisa
        List<Alunos> result = null;

        //compara para ver se existe um aluno
        if (nome.equals(nome)) {
            // receber resultado utilizando stream
            result = aluno.getAluno().stream()
                    .filter(msg -> msg.getNome().contains(nome))
                    .collect(Collectors.toList());
        }
        // caso não haja aluno
        if (nome.equals(null) || nome.equals("")){
            // laca minha exceção personalizada
            throw  new Excecoes();
        }
        // retorna valor
        return result;

    }


    /**  ------------------------------Mapeamento de Filtro por Idade ----------------------------------------**/

    @GetMapping("/idade")
    public List<Alunos> filterIdade(@RequestParam(required = false)Integer idade) throws Excecoes {

        // Cria Lista vazia para receber pesquisa
        List<Alunos> result = null;

        //compara para ver se existe um aluno
        if (idade.equals(idade)) {
            // receber resultado utilizando stream
            result = aluno.getAluno().stream()
                    .filter(msg -> msg.getIdade().equals(idade))
                    .collect(Collectors.toList());
        }
        // caso não haja aluno
        if (idade.equals(null) || idade <= 0){
            // laca minha exceção personalizada
            throw  new Excecoes();
        }
        // retorna valor
        return result;
    }

    /**  ------------------------------Mapeamento de Filtro por ID ----------------------------------------**/

    @GetMapping("/id")
    public List<Alunos> filterID(@RequestParam(required = false) Integer id) throws Excecoes {

        // Cria Lista vazia para receber pesquisa
        List<Alunos> result = null;

        // tratamento de entrada NullPointerExceprion
        try {
            id.equals(null);
        }catch (Exception e){
            throw  new Excecoes();
        }// fim cath



        if ( id != null){
            result =  aluno.getAluno().stream().filter(msg -> msg.getId().equals(id))
                    .collect(Collectors.toList());
        }if (id >= aluno.getAluno().size()+1 ||id.equals(0)){
            // laca minha exceção personalizada
            throw  new Excecoes();
        }
       return result;
    }// fim filterID



    /**  ------------------------------Mapeamento Postanto aluno ----------------------------------------**/

    @PostMapping
    public ResponseEntity<Integer> addAluno(@RequestBody Alunos alunos) {

        if (alunos.getId() == null) {
            alunos.setId(aluno.getAluno().size() + 1);
        }
        aluno.getAluno().add(alunos);

        return new ResponseEntity<>(alunos.getId(), HttpStatus.CREATED);
    }


    /**  ---------------------------Mapeamento Alterando Nome e Idade ------------------------------------**/

    @PutMapping
    public ResponseEntity updateAluno(@RequestBody Alunos alunos) {
        aluno.getAluno().stream().filter(msg -> msg.getId().equals(alunos.getId()))
                .forEach(msg -> msg.setNome(alunos.getNome()));
        aluno.getAluno().stream().filter(msg -> msg.getId().equals(alunos.getId()))
                .forEach(msg -> msg.setIdade(alunos.getIdade()));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    /**  ------------------------------Mapeamento Deletanto Alunos ----------------------------------------**/

    //Deletando Alunos
    @DeleteMapping("/{id}")
    public ResponseEntity deleteAluno(@PathVariable("id") Integer id) {
        aluno.getAluno().removeIf(msg -> msg.getId().equals(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    public AlunosController getAluno() {
        return aluno;
    }

    public void setAluno(AlunosController aluno) {
        this.aluno = aluno;
    }
}

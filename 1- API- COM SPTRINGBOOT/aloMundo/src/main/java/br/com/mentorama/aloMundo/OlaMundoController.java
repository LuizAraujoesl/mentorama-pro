package br.com.mentorama.aloMundo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/olamundo")
public class OlaMundoController {


    private final List<Menssage>menssages;

    public OlaMundoController() {
        this.menssages = new ArrayList<>();
        Menssage menssage1 =  new Menssage(1, "Ola Mundo!");
        Menssage menssage2 =  new Menssage(2, "Hello World!");
        Menssage menssage3 =  new Menssage(3, "Hi gays!");

        this.menssages.add(menssage1);
        this.menssages.add(menssage2);
        this.menssages.add(menssage3);

    }

    @GetMapping
    public List<Menssage> findAll(@RequestParam(required = false) String menssage){
        if (menssage != null){

            return menssages.stream()
                    .filter(msg -> msg.getMenssagem().contains(menssage))
                    .collect(Collectors.toList());
        }
        return menssages;
    }

    @PostMapping
    public ResponseEntity<Integer>add(@RequestBody final Menssage menssage){

        if (menssage.getId() == null){
            menssage.setId(menssages.size() + 1);
        }
        menssages.add(menssage);

        return  new ResponseEntity<>(menssage.getId(), HttpStatus.CREATED)  ;
    }

    @PutMapping
    public ResponseEntity update(@RequestBody final Menssage menssage){
        menssages.stream().filter(msg -> msg.getId().equals(menssage.getId()))
                .forEach(msg -> msg.setMenssagem(menssage.getMenssagem()));
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        menssages.removeIf(msg -> msg.getId().equals(id));
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}


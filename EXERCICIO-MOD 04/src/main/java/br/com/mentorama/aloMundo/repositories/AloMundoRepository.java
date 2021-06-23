package br.com.mentorama.aloMundo.repositories;


import br.com.mentorama.aloMundo.entities.Menssage;
import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AloMundoRepository {

    // lista msg
    private final List<Menssage> menssages;

    // construtor  para lista de msg
    public AloMundoRepository(List<Menssage> menssages) {
        this.menssages = menssages;
    }

    // construtor  recebe msg
    public List<Menssage> findAll() {
        return menssages;
    }
   // construtor recebe msg  com filtro
    public List<Menssage> findAll(final String menssage) {
        return menssages.stream()
                .filter(msg -> msg.getMenssagem().contains(menssage))
                .collect(Collectors.toList());
    }

    // adiciona msg a lista
    public void add(Menssage menssage) {
        this.menssages.add(menssage);
    }

    // conta msg da lista
    public int count() {
        return menssages.size();
    }

    // filtra por id a lista
    public Message findById(@PathVariable("id") Integer id) {
        return (Message) this.menssages.stream()
                .filter(msg -> msg.getId().equals(id))
                .findFirst()
                .orElse(null);
    }// fim findById


    // faz update da msg
    public ResponseEntity update(@RequestBody final Menssage menssage) {
        menssages.stream().filter(msg -> msg.getId().equals(menssage.getId()))
                .forEach(msg -> msg.setMenssagem(menssage.getMenssagem()));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }// fim update


    // deleta msg
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        menssages.removeIf(msg -> msg.getId().equals(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }// fim delete

}

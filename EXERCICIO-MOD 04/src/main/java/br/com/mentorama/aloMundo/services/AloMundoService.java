package br.com.mentorama.aloMundo.services;


import br.com.mentorama.aloMundo.entities.Menssage;
import br.com.mentorama.aloMundo.repositories.AloMundoRepository;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AloMundoService {

    // injecáo de dependencia automatica
    @Autowired
    private AloMundoRepository aloMundoRepository;

    //  recebe e verifica menssages da class AloMundoRepository
    public List<Menssage> findAll(String menssage) {
        if (menssage != null) {
            return aloMundoRepository.findAll(menssage);
        }   return aloMundoRepository.findAll();
    }// fim findAll


    // recebe add mensagem da class AloMundoRepository
    public ResponseEntity<Integer> add(@RequestBody final Menssage menssage) {
        if (menssage.getId() == null) {
            menssage.setId(aloMundoRepository.count() + 1);
        }   aloMundoRepository.add(menssage);
        return new ResponseEntity<>(menssage.getId(), HttpStatus.CREATED);
    }// fim add


    // recebe menssagem por id da class AloMundoRepository
    public Message findById(@PathVariable("id") Integer id) {
        aloMundoRepository.findById(id);
        return null;
    }// fim findById


    // recebe  menssagem  para update da class AloMundoRepository
    public void update(final Menssage menssage) {
        aloMundoRepository.update(menssage);
    }// fim update

    //recebe  id para deletar msg da class AloMundoRepository
    public void delete(Integer id) {
        aloMundoRepository.delete(id);
    }// fim delete

}// fim classe

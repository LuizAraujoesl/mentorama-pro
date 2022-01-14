package com.movies.service;

import com.movies.config.JmsErrorHandler;
import com.movies.model.User;
import com.movies.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public Flux<List<User>> listAllUser(){
        return this.userRepository.findAll().buffer();
    }

    @JmsListener(destination = "mailbox", concurrency = "jmsFactoryQueue")
    public void saveUser( User user){
        LOGGER.info("Save user -> Menssagem recebida salva com sucesso");
        User search = this.userRepository.findById(user.getId()).block();
        assert search != null;
        if(user.getName().equals(search.getName())){
            new JmsErrorHandler();
        }else{
            this.userRepository.save(user);
        }
    }

    @JmsListener(destination = "mailbox", concurrency = "jmsFactoryQueue")
    public void deleteMovies(String id){
        LOGGER.info("Delete user -> Menssagem recebida apagada com sucesso");
        this.userRepository.deleteById(id).block();
    }
}

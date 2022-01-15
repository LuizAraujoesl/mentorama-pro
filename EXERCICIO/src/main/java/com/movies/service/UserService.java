package com.movies.service;

import com.movies.config.JmsErrorHandler;
import com.movies.model.User;
import com.movies.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Component
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public List<User> listAllUser(){
        return this.userRepository.findAll();
    }

    @JmsListener(destination = "saveMailbox", containerFactory = "myFactory")
    public void saveUser( User user){
            this.userRepository.save(user);
        LOGGER.info("Save user -> Menssagem recebida salva com sucesso");
    }

    @JmsListener(destination = "deleteMailbox", containerFactory = "myFactory")
    public void deleteMovies(User user){
        this.userRepository.deleteById(user.getId());
        LOGGER.info("Delete user -> Menssagem recebida apagada com sucesso");
    }
}

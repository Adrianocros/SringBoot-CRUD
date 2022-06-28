package com.projetocrud.crud.config;


import com.projetocrud.crud.entities.User;
import com.projetocrud.crud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

//Classe de configuração para popular o banco de dados com objetos
@Configuration
@Profile("test") //anotação para test
public class TestConfig implements CommandLineRunner {
    @Autowired //Anotação para passociar a dependencia
    private UserRepository userRepository;

    @Override //Para ser executando quando a aplicação for iniciada
    public void run(String... args) throws Exception {

        User u1 = new User(null,"Adriano Bianchi","adrianobiancih@outlook.com","99999999","1234");
        User u2 = new User(null,"Tamara Correa Crosoletto","tamy.comercial@gmail.com","99999999","142321");
        User u3 = new User(null,"Tamires Correa Crosoletto","tamirescorrea@gmail.com","9898989989","1212232");

        userRepository.saveAll(Arrays.asList(u1,u2,u3));
    }
}

package com.projetocrud.crud.config;


import com.projetocrud.crud.entities.Order;
import com.projetocrud.crud.entities.User;
import com.projetocrud.crud.repositories.OrderRepository;
import com.projetocrud.crud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

//Classe de configuração para popular o banco de dados com objetos
@Configuration
@Profile("test") //anotação para test
public class TestConfig implements CommandLineRunner {
    @Autowired //Anotação para passociar a dependencia
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override //Para ser executando quando a aplicação for iniciada
    public void run(String... args) throws Exception {

        User u1 = new User(null,"Adriano Bianchi","adrianobiancih@outlook.com","99999999","1234");
        User u2 = new User(null,"Tamara Correa Crosoletto","tamy.comercial@gmail.com","99999999","142321");
        User u3 = new User(null,"Tamires Correa Crosoletto","tamirescorrea@gmail.com","9898989989","1212232");



        Order o1 = new Order(null,Instant.parse("2022-05-24T10:13:07Z"),u1);
        Order o2 = new Order(null,Instant.parse("2021-02-12T11:23:07Z"),u2);
        Order o3 = new Order(null,Instant.parse("2021-07-30T01:50:07Z"),u2);

        userRepository.saveAll(Arrays.asList(u1,u2,u3));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}

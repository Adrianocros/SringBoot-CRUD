package com.projetocrud.crud.services;


import com.projetocrud.crud.entities.Order;
import com.projetocrud.crud.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //@Component Registra a classe como componente do spring e vira autowired
public class OrderService {
    @Autowired // injeçao de depencencia
    private OrderRepository repository;

    //Metodo para retornar todos os usuarios do banco
    public List<Order> findALl(){
        return repository.findAll();
    }


    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

}

package com.projetocrud.crud.resources;


import com.projetocrud.crud.entities.Order;
import com.projetocrud.crud.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Camada de recursos
@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired //dependencia
    private OrderService service;

    //Metodo que acessa os usuarios
    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = service.findALl();
        return  ResponseEntity.ok().body(list);
    }

    //retornar ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}

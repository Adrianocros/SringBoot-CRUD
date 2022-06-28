package com.projetocrud.crud.resources;


import com.projetocrud.crud.entities.User;
import com.projetocrud.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Camada de recursos
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired //dependencia
    private UserService service;

    //Metodo que acessa os usuarios
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findALl();
        return  ResponseEntity.ok().body(list);
    }

    //retornar ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}

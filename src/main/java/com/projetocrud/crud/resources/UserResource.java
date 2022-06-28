package com.projetocrud.crud.resources;


import com.projetocrud.crud.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Camada de recursos
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    //Metodo que acessa os usuarios
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L,"Maria","maria@gmail.com","999999","1234");
        return  ResponseEntity.ok().body(u);
    }

}

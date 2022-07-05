package com.projetocrud.crud.resources;


import com.projetocrud.crud.entities.User;
import com.projetocrud.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    //Incluir usuario no banco
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    //Deletando do banco de dados
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    //Atualizar usuario
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        obj = service.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }



}

package com.projetocrud.crud.resources;


import com.projetocrud.crud.entities.Category;
import com.projetocrud.crud.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Camada de recursos
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired //dependencia
    private CategoryService service;

    //Metodo que acessa os usuarios
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.findALl();
        return  ResponseEntity.ok().body(list);
    }

    //retornar ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}

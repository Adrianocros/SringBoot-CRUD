package com.projetocrud.crud.resources;


import com.projetocrud.crud.entities.Product;
import com.projetocrud.crud.entities.User;
import com.projetocrud.crud.services.ProductService;
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
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired //dependencia
    private ProductService service;

    //Metodo que acessa os usuarios
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = service.findALl();
        return  ResponseEntity.ok().body(list);
    }

    //retornar ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}

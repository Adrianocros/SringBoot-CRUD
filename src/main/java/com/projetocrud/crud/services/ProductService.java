package com.projetocrud.crud.services;


import com.projetocrud.crud.entities.Product;
import com.projetocrud.crud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //@Component Registra a classe como componente do spring e vira autowired
public class ProductService {
    @Autowired // injeçao de depencencia
    private ProductRepository repository;

    //Metodo para retornar todos os usuarios do banco
    public List<Product> findALl(){
        return repository.findAll();
    }


    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

}

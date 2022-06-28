package com.projetocrud.crud.services;


import com.projetocrud.crud.entities.Category;
import com.projetocrud.crud.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //@Component Registra a classe como componente do spring e vira autowired
public class CategoryService {
    @Autowired // injeçao de depencencia
    private CategoryRepository repository;

    //Metodo para retornar todos os usuarios do banco
    public List<Category> findALl(){
        return repository.findAll();
    }


    public Category findById(Long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }

}

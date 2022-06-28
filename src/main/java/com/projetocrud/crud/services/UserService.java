package com.projetocrud.crud.services;


import com.projetocrud.crud.entities.Usuario;
import com.projetocrud.crud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //@Component Registra a classe como componente do spring e vira autowired
public class UserService {
    @Autowired // injeçao de depencencia
    private UserRepository repository;

    //Metodo para retornar todos os usuarios do banco
    public List<Usuario> findALl(){
        return repository.findAll();
    }


    public Usuario findById(Long id){
        Optional<Usuario> obj = repository.findById(id);
        return obj.get();
    }

}

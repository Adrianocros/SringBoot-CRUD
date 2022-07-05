package com.projetocrud.crud.services;


import com.projetocrud.crud.entities.User;
import com.projetocrud.crud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //@Component Registra a classe como componente do spring e vira autowired
public class UserService {
    @Autowired // injeçao de depencencia
    private UserRepository repository;

    //Metodo para retornar todos os usuarios do banco
    public List<User> findALl(){
        return repository.findAll();
    }


    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }
    //inserir no banco de dados o usuario
    public User insert(User obj){
        return repository.save(obj);
    }

    //Deleção do usuario
    public void delete(Long id){
        repository.deleteById(id);
    }

}

package com.projetocrud.crud.services;


import com.projetocrud.crud.entities.User;
import com.projetocrud.crud.repositories.UserRepository;
import com.projetocrud.crud.services.exceptions.DataBaseException;
import com.projetocrud.crud.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    //inserir no banco de dados o usuario
    public User insert(User obj){
        return repository.save(obj);
    }

    //Deleção do usuario
    public void delete(Long id){
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw  new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
           throw new DataBaseException(e.getMessage());
            }
    }

    //Atualizar o usuario
    public User update(Long id, User obj){
        try {
            User entity = repository.getById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            throw  new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}

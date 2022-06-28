package com.projetocrud.crud.repositories;

import com.projetocrud.crud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//instanciar o objeto e operações para usuario
@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}

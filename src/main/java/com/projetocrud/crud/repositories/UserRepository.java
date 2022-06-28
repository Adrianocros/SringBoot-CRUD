package com.projetocrud.crud.repositories;

import com.projetocrud.crud.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

//instanciar o objeto e operações para usuario
public interface UserRepository extends JpaRepository<Usuario, Long> {


}

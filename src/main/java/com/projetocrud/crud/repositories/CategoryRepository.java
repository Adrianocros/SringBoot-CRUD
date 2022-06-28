package com.projetocrud.crud.repositories;


import com.projetocrud.crud.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//instanciar o objeto e operações para usuario
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}

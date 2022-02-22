package com.example.api_forum.repo;

import com.example.api_forum.Models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin("*")
public interface CategorieRepo extends JpaRepository<Categorie,Long> {

    void deleteByCategorie(Long id);
    Optional<Categorie> findCategorieById(Long id);
}

package com.example.api_forum.repo;

import com.example.api_forum.Models.Membres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MembreRep extends JpaRepository<Membres,Long> {
    Optional<Membres> findMembresById(Long id);
}

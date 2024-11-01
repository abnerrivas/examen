package com.example.examen.examen_final.repository;

import com.example.examen.examen_final.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
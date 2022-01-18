package com.cesarlopez.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cesarlopez.model.Persona;

public interface PersonaDAO extends JpaRepository<Persona, Integer> {

}

package com.cesarlopez.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cesarlopez.model.Producto;

public interface ProductoDAO extends JpaRepository<Producto, Integer> {

}

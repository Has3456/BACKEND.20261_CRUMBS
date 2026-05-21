package com.proyecto_backend.crumbs.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto_backend.crumbs.modelos.Gasto;

@Repository

public interface IGastoRepositorio extends JpaRepository<Gasto, Integer> {
    
}
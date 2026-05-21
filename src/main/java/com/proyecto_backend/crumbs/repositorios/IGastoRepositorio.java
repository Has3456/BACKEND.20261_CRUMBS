package com.proyecto_backend.crumbs.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto_backend.crumbs.modelos.Gasto;
import java.util.List;

@Repository

public interface IGastoRepositorio extends JpaRepository<Gasto, Integer> {
    // Método personalizado para listar gastos por usuario
    List<Gasto> findByUsuarioId(Integer usuarioId);
    // Método personalizado para listar gastos por categoría
}
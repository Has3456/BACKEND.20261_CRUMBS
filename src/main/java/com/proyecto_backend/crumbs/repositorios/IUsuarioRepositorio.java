package com.proyecto_backend.crumbs.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;   
import com.proyecto_backend.crumbs.modelos.Usuario;


@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer> {
}

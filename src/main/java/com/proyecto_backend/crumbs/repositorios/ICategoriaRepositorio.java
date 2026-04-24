package com.proyecto_backend.crumbs.repositorios;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto_backend.crumbs.modelos.Categoria;



@Repository
public interface ICategoriaRepositorio extends JpaRepository<Categoria, Integer> {

}

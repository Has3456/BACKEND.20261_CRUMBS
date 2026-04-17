package com.proyecto_backend.crumbs.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;   

import com.proyecto_backend.crumbs.modelos.Usuario;
import com.proyecto_backend.crumbs.modelos.TipoDocumento;


@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario,Integer> {

    //considero una consulta personalizada POR AHORA COMO UNA BUSQUEDA

    //1. DEFINO QUE ATRIBUTOS TIENE MI MODELO Y SOLO SOBRE ESOS ATRIBUTOS PUEDO IMPLMENTAR LAS BUSQUEDAS

    //BUSCAR POR NOMBRE
    List<Usuario> findByNombres(String nombres);

    //BUSCAR POR TIPO DE DOCUMENTO
    List<Usuario> findByTipoDocumento(TipoDocumento tipoDocumento);

    //BUSCAR POR DOCUMENTO
    Optional<Usuario> findByDocumento(String documento);

    //BUSCAR POR EDAD
    List<Usuario> findByEdad(Integer edad);


}

package com.proyecto_backend.crumbs.repositorios;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;   
import com.proyecto_backend.crumbs.modelos.Usuario;
import com.proyecto_backend.crumbs.modelos.TipoDocumento;


@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    
    //BUSCAR POR NOMBRE
    List<Usuario> findByNombres(String nombres);

    //BUSCAR POR TIPO DE DOCUMENTO
    List<Usuario> findByTipoDocumento(String tipoDocumento);

    //BUSCAR POR DOCUMENTO
    Optional<Usuario> findByDocumento(String documento);

    //BUSCAR POR EDAD
    List<Usuario> findByEdad(Integer edad);

    //BUSCAR POR OCUPACION PRINCIPAL
    List<Usuario> findByOcupacionPrincipal(String ocupacionPrincipal);

    //BUSCAR POR NIVEL SOCIOECONOMICO
    List<Usuario> findByNivelSocioeconomico(String nivelSocioeconomico);

    //BUSCAR POR RANGO DE INGRESOS MENSUALES
    List<Usuario> findByRangoIngresosMensuales(String rangoIngresosMensuales);

    //BUSCAR POR UBICACION GEOGRAFICA
    List<Usuario> findByUbicacionGeografica(String ubicacionGeografica);

    //BUSCAR POR GENERO
    List<Usuario> findByGenero(String genero);

}

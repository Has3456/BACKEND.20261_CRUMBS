package com.proyecto_backend.crumbs.repositorios;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto_backend.crumbs.modelos.Categoria;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface ICategoriaRepositorio extends JpaRepository<Categoria, Integer> {

    //1 NOMBRE
    Optional<Categoria> findByNombre(String nombre);   

    //2 FECHA DE CREACION
    List <Categoria> findByFechaCreacion(String fechaCreacion);

    //3 FECHA DE CREACION 
    List <Categoria> findByFechaCreacionBetween(LocalDate fechaInicio);

    //4 RESPONSABLE
    List <Categoria> findByResponsable(String responsable);

    //5 JUSTIFICACION   
    List <Categoria> findByJustificacion(String justificacion);

    //6 NATURALEZA DE GASTO
    List <Categoria> findByNaturalezaGasto(String naturalezaGasto);

    //7 COMPORTAMIENTO ESPERADO
    List <Categoria> findByComportamientoEsperado(String comportamientoEsperado);

    //8 PERIODICIDAD SUGERIDA
    List <Categoria> findByPeriodicidadSugerida(String periodicidadSugerida);

    //9 CLASE DE CONSUMO
    List <Categoria> findByClaseConsumo(String claseConsumo);

    //10 LIMITE OPERATIVO
    List <Categoria> findByLimiteOperativo(Double limiteOperativo);

}

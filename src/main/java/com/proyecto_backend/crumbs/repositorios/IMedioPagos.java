package com.proyecto_backend.crumbs.repositorios;

import java. util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto_backend.crumbs.modelos.MedioPagos;
import java.time.LocalDateTime;




@Repository
public interface IMedioPagosRepositorio extends JpaRepository<MedioPagos, Integer> {

    
    //1. DEFINO QUE ATRIBUTOS TIENE MI MODELO Y SOLO SOBRE ESOS ATRIBUTOS PUEDO IMPLMENTAR LAS BUSQUEDAS

     //BUSCAR POR NOMBRE
    List<MedioPago> findByNombre(String nombre);
  
    //BUSCAR POR FECHA DE CREACION
    List<MedioPago> findByFechaCreacion(LocalDateTime fechaCreacion);

    //BUSCAR POR RESPONSABLE
    List<MedioPago> findByResponsable(String responsable);

    //BUSCAR POR JUSTIFICACION
    List<MedioPago> findByJustificacion(String justificacion);
    



}

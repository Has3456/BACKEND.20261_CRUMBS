package com.proyecto_backend.crumbs.repositorios;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto_backend.crumbs.modelos.Comercio;



@Repository

public interface IComercioRepositorio extends JpaRepository<Comercio,Integer> {


    //1. BUSCAR POR NIT    
    Optional<Comercio> findByNit(String nit);

    //2. BUSCAR POR NOMBRE
    List<Comercio> findByNombre(String nombre);

    //3 BUSCAR POR ACTIVIDAD
    List<Comercio> findByActividad(String actividad);

    //4 BUSCAR POR CONTACTO
    List<Comercio> findByContacto(String contacto);

    //5 BUSCAR POR SEGMENTO DE MERCADO
    List<Comercio> findBySegmentoMercado(String segmentoMercado);

    //6 BUSCAR POR CANAL DE VENTA
    List<Comercio> findByCanalVenta(String canalVenta);

    //7 BUSCAR POR FIDELIZACION ACTIVA
    List<Comercio> findByFidelizacionActiva(Boolean fidelizacionActiva);

    //8 BUSCAR POR CALIFICACION DE CONFIANZA
    List<Comercio> findByCalificacionConfianza(Integer calificacionConfianza);

    //9 BUSCAR POR FRECUENCIA DE RECURRENCIA
    List<Comercio> findByFrecuenciaRecurrencia(Integer frecuenciaRecurrencia);
}

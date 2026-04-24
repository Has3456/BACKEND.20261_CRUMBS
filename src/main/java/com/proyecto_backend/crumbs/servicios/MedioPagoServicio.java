package com.proyecto_backend.crumbs.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

import com.proyecto_backend.crumbs.modelos.MedioPago;
import com.proyecto_backend.crumbs.repositorios.IMedioPagoRepositorio;

@Service
public class MedioPagoServicio {
    
    @Autowired
    private IMedioPagoRepositorio repositorio;

    // MÉTODO 1: GUARDAR
    public MedioPago guardar_medio_pago(MedioPago datosMedioPago) {
        // 1. Validaciones
        if (datosMedioPago.getNombre() == null || datosMedioPago.getNombre().isEmpty() || datosMedioPago.getNombre().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Apreciado usuario, el nombre del medio de pago es obligatorio"
            );
        }

        // 2. Si pasó la validación, guardar y retornar
        return repositorio.save(datosMedioPago);
    } 

    // MÉTODO 2: LISTAR
    public List<MedioPago> listar_medios_pago() {
        return repositorio.findAll();
    } 

} 
package com.proyecto_backend.crumbs.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

import com.proyecto_backend.crumbs.modelos.MedioPago;
import com.proyecto_backend.crumbs.repositorios.IMedioPagoRepositorio;
import java.util.Optional;

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

    ///////////////////////////
      //funcion para modificar un usuario
    public MedioPago modificar_medio_pago(Integer id, MedioPago datosNuevos){


        Optional<MedioPago> medio_pago_que_busco=repositorio.findById(id);
        if(medio_pago_que_busco.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Medio de pago no encontrado"
            );

        }else{

            MedioPago medio_pago_encontrado=medio_pago_que_busco.get();
            //modifiquemos datos
            medio_pago_encontrado.setJustificacion(datosNuevos.getJustificacion());
            medio_pago_encontrado.setNombre(datosNuevos.getNombre());
            return repositorio.save(medio_pago_encontrado);
           
        }

    }
        
       ///////////////////////////////////
           //funcion para eliminar un usuario
    public boolean eliminar_medio_pago(Integer id){

        Optional<MedioPago> medio_pago_que_busco=repositorio.findById(id);
        if(medio_pago_que_busco.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Medio de pago no encontrado"
            );

        }else{
           repositorio.deleteById(id);
           return true;
        }


    }

    /////////////////////////////
        //funcion para buscar un usuario por id
    public MedioPago buscar_medio_pago_por_id(Integer id){

        Optional<MedioPago> medio_pago_que_busco=repositorio.findById(id);
        if(medio_pago_que_busco.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Medio de pago no encontrado"
            );

        }else{
            return medio_pago_que_busco.get();
        }

    }
    








} 
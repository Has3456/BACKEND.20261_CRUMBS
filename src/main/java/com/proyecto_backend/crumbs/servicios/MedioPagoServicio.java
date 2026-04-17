package com.proyecto_backend.crumbs.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.proyecto_backend.crumbs.modelos.MedioPago;
import com.proyecto_backend.crumbs.repositorios.IMedioPagoRepositorio;

@Service
public class MedioPagoServicio {


  @Autowired
    private IMedioPagoRepositorio repositorio;

    //Se programa una funcion por cada servicio que voy a ofrecer


    //funcion para guardar un usuario
    public MedioPago guardar_medio_pago(MedioPago datosMedioPago){
        //validar los campos del modelo segun la LN

        //validar que el usuario me mande sus nombres
        if(datosMedioPago.getNombre()==null || datosMedioPago.getNombre().isEmpty() || datosMedioPago.getNombre().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Apreciado usuario, el nombre de usuario es obligatorio"
            );

        }


        //valdiar documento tenga al menos 6 caracteres
        if(datosMedioPago.getDocumento().length()<6){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Apreciado usuario, el documento debe tener mas de 6 caracteres"
            );

        }

        //Si paso todas las validaciones
        //intentare activar el guardado de los datos
        return repositorio.save(datosMedioPago);

    }

    //funcion para listar todos los usuarios

    public List<MedioPago> listar_medios_pago(){
        return repositorio.findAll();
    }



}

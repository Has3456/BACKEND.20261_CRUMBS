package com.proyecto_backend.crumbs.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.proyecto_backend.crumbs.modelos.Comercio;
import com.proyecto_backend.crumbs.repositorios.IComercioRepositorio;

@Service
public class ComercioServicio {

    @Autowired
    private IComercioRepositorio repositorio;

    public Comercio guardar_comercio(Comercio datosComercio){
        //validar los campos del modelo segun la LN

        //validar que el comercio me mande su nombre
        if(datosComercio.getNombre()==null || datosComercio.getNombre().isEmpty() || datosComercio.getNombre().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Apreciado usuario, el nombre del comercio es obligatorio"
            );

        }

        //Si paso todas las validaciones
        //intentare activar el guardado de los datos
        return repositorio.save(datosComercio);

    }

    //funcion para listar todos los comercios
    public List<Comercio> listar_comercios(){
        return repositorio.findAll();
    }

    

}
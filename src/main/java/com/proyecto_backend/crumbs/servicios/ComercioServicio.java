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

    //Inyectando la dependencia al repositorio Comercio
    @Autowired
    private IComercioRepositorio repositorio;

    //Se programa una funcion por cada servicio que voy a ofrecer

    //funcion para guardar un comercio
    public Comercio guardar_comercio(Comercio datosComercio){
        //validar los campos del modelo segun la LN

        //validar que el usuario mande el NIT
        if(datosComercio.getNit()==null || datosComercio.getNit().isEmpty() || datosComercio.getNit().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Apreciado usuario, el NIT del comercio es obligatorio"
            );
        }

        //validar que el usuario mande el nombre
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

    //funcion para buscar un comercio por id
    public Comercio buscar_por_id(Integer id){
        try {
            return repositorio.findById(id).get();
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Apreciado usuario, el comercio no existe"
            );
        }
    }

    //funcion para modificar un comercio
    public Comercio modificar_comercio(Integer id, Comercio datosNuevos){
        try {
            // Verificar si existe antes de intentar guardar
            buscar_por_id(id);
            return repositorio.save(datosNuevos);
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Apreciado usuario, no se pudo modificar el registro"
            );
        }
    }

    //funcion para eliminar un comercio
    public boolean eliminar_comercio(Integer id){
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Apreciado usuario, no se pudo eliminar el registro"
            );
        }
    }
}
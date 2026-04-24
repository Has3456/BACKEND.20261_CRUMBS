package com.proyecto_backend.crumbs.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.proyecto_backend.crumbs.modelos.Gasto;
import com.proyecto_backend.crumbs.repositorios.IGastoRepositorio;

@Service
public class GastoServicio {

    @Autowired
    private IGastoRepositorio repositorio;

    public Gasto guardar_gasto(Gasto datosGasto){
        //validar los campos del modelo segun la LN

        //validar que el gasto tenga un valor mayor a 0
        if(datosGasto.getValor()<=0){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Apreciado usuario, el valor del gasto debe ser mayor a 0"
            );

        }

        //Si paso todas las validaciones
        //intentare activar el guardado de los datos
        return repositorio.save(datosGasto);

    }

    //funcion para listar todos los gastos
    public List<Gasto> listar_gastos(){
        return repositorio.findAll();
    }
    
}
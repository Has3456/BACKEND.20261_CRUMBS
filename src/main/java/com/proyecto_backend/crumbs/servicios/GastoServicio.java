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

    //Inyectando la dependencia al repositorio Gasto
    @Autowired
    private IGastoRepositorio repositorio;

    //Se programa una funcion por cada servicio que voy a ofrecer

    //funcion para guardar un gasto
    public Gasto guardar_gasto(Gasto datosGasto){
        //validar los campos del modelo segun la LN

        //validar que el usuario me mande la descripcion
        if(datosGasto.getDescripcion()==null || datosGasto.getDescripcion().isEmpty() || datosGasto.getDescripcion().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Apreciado usuario, la descripción del gasto es obligatoria"
            );
        }

        //validar que el valor sea un número positivo
        if(datosGasto.getValor() == null || datosGasto.getValor() <= 0){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Apreciado usuario, el valor del gasto debe ser mayor a cero"
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

    //funcion para buscar un gasto por id
    public Gasto buscar_por_id(Integer id){
        try {
            return repositorio.findById(id).get();
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Apreciado usuario, el gasto buscado no existe"
            );
        }
    }

    //funcion para modificar un gasto
    public Gasto modificar_gasto(Integer id, Gasto datosNuevos){
        try {
            // Verificar si existe antes de intentar guardar
            buscar_por_id(id);
            // Al recibir el ID en el cuerpo o por parámetro, Spring JPA actualiza el registro
            return repositorio.save(datosNuevos);
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Apreciado usuario, no se pudo modificar el registro"
            );
        }
    }

    //funcion para eliminar un gasto
    public boolean eliminar_gasto(Integer id){
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
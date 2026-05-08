package com.proyecto_backend.crumbs.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.proyecto_backend.crumbs.modelos.Gasto;
import com.proyecto_backend.crumbs.repositorios.IGastoRepositorio;
import java.util.Optional;
import com.proyecto_backend.crumbs.modelos.Categoria;
import com.proyecto_backend.crumbs.modelos.Comercio;


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
    

    // Funcion para modificar un gasto
    public Gasto modificar_gasto(Integer id, Gasto datosNuevos) {
        Optional<Gasto> gasto_que_busco = repositorio.findById(id);

        if (gasto_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Gasto no encontrado"
            );
        } else {
            Gasto gasto_encontrado = gasto_que_busco.get();

            gasto_encontrado.setValor(datosNuevos.getValor());
            gasto_encontrado.setDescripcion(datosNuevos.getDescripcion());

            return repositorio.save(gasto_encontrado);
        }
    }

    // Funcion para eliminar un gasto
    public boolean eliminar_gasto(Integer id) {
        Optional<Gasto> gasto_que_busco = repositorio.findById(id);

        if (gasto_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Gasto no encontrado"
            );
        } else {
            repositorio.deleteById(id);
            return true;
        }
      }

    // Funcion para buscar un gasto por id
    public Gasto buscar_gasto_por_id(Integer id) {
        Optional<Gasto> gasto_que_busco = repositorio.findById(id);

        if (gasto_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Gasto no encontrado"
            );
        } else {
            return gasto_que_busco.get();
        }
    }
}
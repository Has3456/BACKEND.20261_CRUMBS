package com.proyecto_backend.crumbs.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.proyecto_backend.crumbs.modelos.Categoria;
import com.proyecto_backend.crumbs.repositorios.ICategoriaRepositorio;

@Service
public class CategoriaServicio {

    //Inyectando la dependencia al repositorio Categoria
    @Autowired
    private ICategoriaRepositorio repositorio;

    //Se programa una funcion por cada servicio que voy a ofrecer

    //funcion para guardar una categoria
    public Categoria guardar_categoria(Categoria datosCategoria){
        //validar los campos del modelo segun la LN

        //validar que el usuario mande el nombre
        if(datosCategoria.getNombre()==null || datosCategoria.getNombre().isEmpty() || datosCategoria.getNombre().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Apreciado usuario, el nombre de la categoría es obligatorio"
            );
        }

        //validar que el usuario mande la naturaleza del gasto
        if(datosCategoria.getNaturalezaGasto()==null || datosCategoria.getNaturalezaGasto().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Apreciado usuario, la naturaleza del gasto es obligatoria"
            );
        }

        //Si paso todas las validaciones
        //intentare activar el guardado de los datos
        return repositorio.save(datosCategoria);
    }

    //funcion para listar todas las categorias
    public List<Categoria> listar_categorias(){
        return repositorio.findAll();
    }

    //funcion para buscar una categoria por id
    public Categoria buscar_por_id(Integer id){
        try {
            return repositorio.findById(id).get();
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Apreciado usuario, la categoría no existe"
            );
        }
    }

    //funcion para modificar una categoria
    public Categoria modificar_categoria(Integer id, Categoria datosNuevos){
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

    //funcion para eliminar una categoria
    public boolean eliminar_categoria(Integer id){
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
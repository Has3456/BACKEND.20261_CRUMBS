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

    @Autowired
    private ICategoriaRepositorio categoriaRepositorio;

    public Categoria guardar_categoria(Categoria datosCategoria){
        //validar los campos del modelo segun la LN

        //validar que el comercio me mande su nombre
        if(datosCategoria.getNombre()==null || datosCategoria.getNombre().isEmpty() || datosCategoria.getNombre().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Apreciado usuario, el nombre de la categoria es obligatorio"
            );

        }

        //Si paso todas las validaciones
        //intentare activar el guardado de los datos
        return categoriaRepositorio.save(datosCategoria);

    }

    //funcion para listar todas las categorias
    public List<Categoria> listar_categorias(){
        return categoriaRepositorio.findAll();
    }

    // Función para modificar una categoría
    public Categoria modificar_categoria(Integer id, Categoria datosNuevos) {
        Optional<Categoria> categoria_que_busco = categoriaRepositorio.findById(id);

        if (categoria_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Categoría no encontrada"
            );
        } else {
            Categoria categoria_encontrada = categoria_que_busco.get();
            categoria_encontrada.setNombre(datosNuevos.getNombre());
            return categoriaRepositorio.save(categoria_encontrada);
        }
    }

    // Función para eliminar una categoría
    public boolean eliminar_categoria(Integer id) {
        Optional<Categoria> categoria_que_busco = categoriaRepositorio.findById(id);

        if (categoria_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Categoría no encontrada"
            );
        } else {
            categoriaRepositorio.deleteById(id);
            return true;
        }
    }

    // Función para buscar una categoría por id
    public Categoria buscar_categoria_por_id(Integer id) {
        Optional<Categoria> categoria_que_busco = categoriaRepositorio.findById(id);

        if (categoria_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Categoría no encontrada"
            );
        } else {
            return categoria_que_busco.get();
        }
    }

    
}
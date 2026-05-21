package com.proyecto_backend.crumbs.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.proyecto_backend.crumbs.modelos.Categoria;
import com.proyecto_backend.crumbs.modelos.Usuario;
import com.proyecto_backend.crumbs.repositorios.ICategoriaRepositorio;
import com.proyecto_backend.crumbs.repositorios.IUsuarioRepositorio;




import java.util.Optional;


@Service
public class CategoriaServicio {

    @Autowired
    private ICategoriaRepositorio categoriaRepositorio;

    @Autowired
    private IUsuarioRepositorio usuarioRepositorio;



 
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




        public Categoria guardar_categoria(Integer usuarioId, Categoria datosCategoria) {
    // 1. Validar nombre
    if(datosCategoria.getNombre()==null || datosCategoria.getNombre().isEmpty()){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nombre obligatorio");
    }

    Usuario usuario = usuarioRepositorio.findById(usuarioId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

    datosCategoria.setUsuario(usuario);
    return categoriaRepositorio.save(datosCategoria);
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

 
    public List<Categoria> listar_categorias_por_usuario(Integer usuarioId) {
    // Esto hace la consulta SQL "WHERE usuario_id = ?" automáticamente
    return categoriaRepositorio.findByUsuarioId(usuarioId);
}

    
}
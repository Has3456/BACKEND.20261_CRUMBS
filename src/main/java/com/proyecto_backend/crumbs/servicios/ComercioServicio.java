package com.proyecto_backend.crumbs.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

import com.proyecto_backend.crumbs.modelos.Comercio;
import com.proyecto_backend.crumbs.modelos.Usuario;
import com.proyecto_backend.crumbs.repositorios.IComercioRepositorio;
import com.proyecto_backend.crumbs.repositorios.IUsuarioRepositorio;

@Service
public class ComercioServicio {

    @Autowired
    private IComercioRepositorio repositorio;

    @Autowired
    private IUsuarioRepositorio usuarioRepositorio;


    // Funcion para guardar un comercio
    public Comercio guardar_comercio(Integer usuarioId, Comercio datosComercio) {

        // Validar que el nombre no sea nulo ni vacío
        if (datosComercio.getNombre() == null || datosComercio.getNombre().isEmpty() || datosComercio.getNombre().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Apreciado usuario, el nombre del comercio es obligatorio"
            );
        }

        // Buscar y asociar el usuario
        Optional<Usuario> usuario_que_busco = usuarioRepositorio.findById(usuarioId);
        if (usuario_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Usuario no encontrado"
            );
        }

        datosComercio.setUsuario(usuario_que_busco.get());
        return repositorio.save(datosComercio);
    }


    // Funcion para listar todos los comercios
    public List<Comercio> listar_comercios() {
        return repositorio.findAll();
    }


    // Funcion para modificar un comercio
    public Comercio modificar_comercio(Integer id, Comercio datosNuevos) {

        Optional<Comercio> comercio_que_busco = repositorio.findById(id);
        if (comercio_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Comercio no encontrado"
            );
        } else {
            Comercio comercio_encontrado = comercio_que_busco.get();
            // Modificar campos importantes
            comercio_encontrado.setNombre(datosNuevos.getNombre());
            comercio_encontrado.setActividad(datosNuevos.getActividad());
            return repositorio.save(comercio_encontrado);
        }
    }


    // Funcion para eliminar un comercio
    public boolean eliminar_comercio(Integer id) {

        Optional<Comercio> comercio_que_busco = repositorio.findById(id);
        if (comercio_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Comercio no encontrado"
            );
        } else {
            repositorio.deleteById(id);
            return true;
        }
    }


    // Funcion para buscar un comercio por id
    public Comercio buscar_comercio_por_id(Integer id) {

        Optional<Comercio> comercio_que_busco = repositorio.findById(id);
        if (comercio_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Comercio no encontrado"
            );
        } else {
            return comercio_que_busco.get();
        }
    }




}

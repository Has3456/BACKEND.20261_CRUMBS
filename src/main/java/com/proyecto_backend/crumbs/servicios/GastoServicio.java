package com.proyecto_backend.crumbs.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

import com.proyecto_backend.crumbs.modelos.Gasto;
import com.proyecto_backend.crumbs.modelos.Usuario;
import com.proyecto_backend.crumbs.repositorios.IGastoRepositorio;
import com.proyecto_backend.crumbs.repositorios.IUsuarioRepositorio;

@Service
public class GastoServicio {

    @Autowired
    private IGastoRepositorio repositorio;

    @Autowired
    private IUsuarioRepositorio usuarioRepositorio;

   
  

    // Funcion para guardar un gasto
    public Gasto guardar_gasto(Integer usuarioId, Gasto datosGasto) {

        // Validar que la descripcion no sea nula ni vacía
        if (datosGasto.getDescripcion() == null || datosGasto.getDescripcion().isEmpty() || datosGasto.getDescripcion().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Apreciado usuario, la descripcion del gasto es obligatoria"
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

        datosGasto.setUsuario(usuario_que_busco.get());
        return repositorio.save(datosGasto);
    }


    // Funcion para listar todos los gastos
    public List<Gasto> listar_gastos() {
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
            // Modificar campos importantes
            gasto_encontrado.setDescripcion(datosNuevos.getDescripcion());
            gasto_encontrado.setFecha(datosNuevos.getFecha());
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

package com.proyecto_backend.crumbs.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.proyecto_backend.crumbs.modelos.Gasto;
import com.proyecto_backend.crumbs.modelos.Usuario;
import com.proyecto_backend.crumbs.repositorios.IGastoRepositorio;
import com.proyecto_backend.crumbs.repositorios.IUsuarioRepositorio;
import java.util.Optional;


@Service
public class GastoServicio {

    @Autowired
    private IGastoRepositorio repositorio;
  
    @Autowired
    private IUsuarioRepositorio usuarioRepositorio;
    


    public Gasto guardar_gasto(Integer usuarioId, Gasto datosGasto) {
    Usuario usuario = usuarioRepositorio.findById(usuarioId).orElse(null);
    datosGasto.setUsuario(usuario);
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

    public List<Gasto> listar_gastos_por_usuario(Integer usuarioId) {
    return repositorio.findByUsuarioId(usuarioId);
}
}
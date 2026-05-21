package com.proyecto_backend.crumbs.servicios;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
 
import com.proyecto_backend.crumbs.modelos.MedioPago;
import com.proyecto_backend.crumbs.modelos.Usuario;
import com.proyecto_backend.crumbs.repositorios.IMedioPagoRepositorio;
import com.proyecto_backend.crumbs.repositorios.IUsuarioRepositorio;

 
@Service
public class MedioPagoServicio {
 
    @Autowired
    private IMedioPagoRepositorio repositorio;
 
    @Autowired
    private IUsuarioRepositorio usuarioRepositorio;

    // Funcion para guardar un medio de pago
    public MedioPago guardar_medio_pago(Integer usuarioId, MedioPago datosMedioPago) {
 
        // Validar que el nombre no sea nulo ni vacío
        if (datosMedioPago.getNombre() == null || datosMedioPago.getNombre().isEmpty() || datosMedioPago.getNombre().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Apreciado usuario, el nombre del medio de pago es obligatorio"
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
 
        datosMedioPago.setUsuario(usuario_que_busco.get());
        return repositorio.save(datosMedioPago);
    }
 
 
    // Funcion para listar todos los medios de pago
    public List<MedioPago> listar_medios_pago() {
        return repositorio.findAll();
    }
 
 
    // Funcion para modificar un medio de pago
    public MedioPago modificar_medio_pago(Integer id, MedioPago datosNuevos) {
 
        Optional<MedioPago> medio_pago_que_busco = repositorio.findById(id);
        if (medio_pago_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Medio de pago no encontrado"
            );
        } else {
            MedioPago medio_pago_encontrado = medio_pago_que_busco.get();
            // Modificar campos importantes
            medio_pago_encontrado.setNombre(datosNuevos.getNombre());
            medio_pago_encontrado.setResponsable(datosNuevos.getResponsable());
            return repositorio.save(medio_pago_encontrado);
        }
    }
 
 
    // Funcion para eliminar un medio de pago
    public boolean eliminar_medio_pago(Integer id) {
 
        Optional<MedioPago> medio_pago_que_busco = repositorio.findById(id);
        if (medio_pago_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Medio de pago no encontrado"
            );
        } else {
            repositorio.deleteById(id);
            return true;
        }
    }
 
 
    // Funcion para buscar un medio de pago por id
    public MedioPago buscar_medio_pago_por_id(Integer id) {
 
        Optional<MedioPago> medio_pago_que_busco = repositorio.findById(id);
        if (medio_pago_que_busco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Medio de pago no encontrado"
            );
        } else {
            return medio_pago_que_busco.get();
        }
    }
 
 

}
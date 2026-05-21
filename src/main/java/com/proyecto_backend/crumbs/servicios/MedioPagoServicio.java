package com.proyecto_backend.crumbs.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

import com.proyecto_backend.crumbs.modelos.MedioPago;
import com.proyecto_backend.crumbs.modelos.Usuario; // Importa el modelo Usuario
import com.proyecto_backend.crumbs.repositorios.IMedioPagoRepositorio;
import com.proyecto_backend.crumbs.repositorios.IUsuarioRepositorio; // Importa tu repositorio de Usuario

@Service
public class MedioPagoServicio {
    
    @Autowired
    private IMedioPagoRepositorio repositorio;

    @Autowired
    private IUsuarioRepositorio usuarioRepositorio; // INYECTAR EL REPOSITORIO DE USUARIO

    // MÉTODO 1: GUARDAR (ACTUALIZADO PARA RECIBIR usuarioId)
    public MedioPago guardar_medio_pago(Integer usuarioId, MedioPago datosMedioPago) {
        // 1. Validaciones
        if (datosMedioPago.getNombre() == null || datosMedioPago.getNombre().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Apreciado usuario, el nombre del medio de pago es obligatorio"
            );
        }

        // 2. Buscar el usuario
        Usuario usuario = usuarioRepositorio.findById(usuarioId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Usuario no encontrado con ID: " + usuarioId
            ));

        // 3. Asociar el usuario al medio de pago
        datosMedioPago.setUsuario(usuario);

        // 4. Guardar y retornar
        return repositorio.save(datosMedioPago);
    } 

    // ... el resto de tus métodos (listar, modificar, eliminar, buscar) permanecen igual ...

    public List<MedioPago> listar_medios_pago() {
        return repositorio.findAll();
    } 

    public MedioPago modificar_medio_pago(Integer id, MedioPago datosNuevos){
        Optional<MedioPago> medio_pago_que_busco = repositorio.findById(id);
        if(medio_pago_que_busco.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Medio de pago no encontrado");
        } else {
            MedioPago medio_pago_encontrado = medio_pago_que_busco.get();
            medio_pago_encontrado.setJustificacion(datosNuevos.getJustificacion());
            medio_pago_encontrado.setNombre(datosNuevos.getNombre());
            return repositorio.save(medio_pago_encontrado);
        }
    }
        
    public boolean eliminar_medio_pago(Integer id){
        Optional<MedioPago> medio_pago_que_busco = repositorio.findById(id);
        if(medio_pago_que_busco.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Medio de pago no encontrado");
        } else {
            repositorio.deleteById(id);
            return true;
        }
    }


   public List<MedioPago> listar_medios_por_usuario(Integer usuarioId) {
    return repositorio.findByUsuarioId(usuarioId);
}
}
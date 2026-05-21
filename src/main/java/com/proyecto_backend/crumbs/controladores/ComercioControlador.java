package com.proyecto_backend.crumbs.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import com.proyecto_backend.crumbs.modelos.Comercio;
import com.proyecto_backend.crumbs.servicios.ComercioServicio;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/crumbs/comercios")
public class ComercioControlador {

    @Autowired
    ComercioServicio servicio;

    // AÑADIDO: @PostMapping con usuarioId
    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> controladorGuardar(@PathVariable Integer usuarioId, @RequestBody Comercio datos) {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_comercio(usuarioId, datos)
        );
    }

    // AÑADIDO: @GetMapping para listar por usuario
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> controladorListarPorUsuario(@PathVariable Integer usuarioId) {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_comercios_por_usuario(usuarioId)
        );
    }

    
    // Modificar, Eliminar y Buscar por ID siguen igual, 
    // asegúrate de tener sus anotaciones:
    @PutMapping("/{id}")
    public ResponseEntity<?> controladorModificar(@PathVariable Integer id, @RequestBody Comercio datos) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.modificar_comercio(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> controladorEliminar(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.eliminar_comercio(id));
    }
}
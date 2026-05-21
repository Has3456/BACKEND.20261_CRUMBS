package com.proyecto_backend.crumbs.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.proyecto_backend.crumbs.servicios.MedioPagoServicio;
import com.proyecto_backend.crumbs.modelos.MedioPago;

@RestController
@RequestMapping("/api/crumbs/medios_pago")
public class MedioPagoControlador {
    
    @Autowired
    MedioPagoServicio servicio;

    // --- CORRECCIÓN: Añadido @PostMapping y la ruta específica ---
    // La URL resultante será: POST /api/crumbs/medios_pago/usuario/{usuarioId}
    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> controladorGuardar(@PathVariable Integer usuarioId, @RequestBody MedioPago datos) {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_medio_pago(usuarioId, datos)
        );
    }

    // --- Listar todos los medios de pago: GET /api/crumbs/medios_pago ---
    @GetMapping
    public ResponseEntity<?> controladorListar() {
         return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_medios_pago()
         );
    }

    // --- Buscar por ID: GET /api/crumbs/medios_pago/{id} ---   
 // --- CORRECCIÓN ---
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> controladorListarPorUsuario(@PathVariable Integer usuarioId) {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_medios_por_usuario(usuarioId)
        );
    }

    // --- Modificar: PUT /api/crumbs/medios_pago/{id} ---
    @PutMapping("/{id}")
    public ResponseEntity<?> controladorModificar(@PathVariable Integer id, @RequestBody MedioPago datos) {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.modificar_medio_pago(id, datos)
        );
    } 

    // --- Eliminar: DELETE /api/crumbs/medios_pago/{id} ---
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controladorEliminar(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.eliminar_medio_pago(id)
        );
    }

    
}
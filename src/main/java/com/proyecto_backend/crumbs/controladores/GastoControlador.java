package com.proyecto_backend.crumbs.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import com.proyecto_backend.crumbs.modelos.Gasto;
import com.proyecto_backend.crumbs.servicios.GastoServicio;     
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto_backend.crumbs.repositorios.IGastoRepositorio;


@RestController
@RequestMapping("/api/crumbs/gastos")
public class GastoControlador {

    @Autowired
    GastoServicio servicio;
    @Autowired
    IGastoRepositorio gastoRepositorio;
    

 
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> controladorListarPorUsuario(@PathVariable Integer usuarioId) {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_gastos_por_usuario(usuarioId)
        );
    }

    // Control para modificar un gasto
    @PutMapping("/{id}")
    public ResponseEntity<?> controladorModificar(@PathVariable Integer id, @RequestBody Gasto datos) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.modificar_gasto(id, datos));
    }

       @PostMapping("/usuario/{usuarioId}")
     public ResponseEntity<?> controladorGuardar(@PathVariable Integer usuarioId, @RequestBody Gasto datos) {
    // Le pasamos al servicio el ID del usuario y el objeto completo
     return ResponseEntity.status(HttpStatus.OK).body(
        servicio.guardar_gasto(usuarioId, datos)
    );
}

    // Control para eliminar un gasto
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controladorEliminar(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.eliminar_gasto(id));
    }

    

}

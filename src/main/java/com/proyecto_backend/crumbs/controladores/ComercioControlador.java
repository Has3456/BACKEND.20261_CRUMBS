package com.proyecto_backend.crumbs.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

import com.proyecto_backend.crumbs.modelos.Comercio;
import com.proyecto_backend.crumbs.servicios.ComercioServicio;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("api/v1/comercios")
public class ComercioControlador {

    @Autowired
    ComercioServicio servicio;

 
    @PostMapping("/{usuarioId}")
        public ResponseEntity<?> controaldorGuardar(@PathVariable Integer usuarioId, @RequestBody Comercio datos) {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.guardar_comercio(usuarioId, datos));
        }


    @GetMapping
    public ResponseEntity<?> controaldorListar() {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.listar_comercios());
    }

    // control para modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> controaldorModificar(@PathVariable Integer id, @RequestBody Comercio datos) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.modificar_comercio(id, datos));
    }

    // control para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controaldorEliminar(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.eliminar_comercio(id));
    }

    // control para buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> controaldorBuscarPorId(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.buscar_comercio_por_id(id));
    }

}

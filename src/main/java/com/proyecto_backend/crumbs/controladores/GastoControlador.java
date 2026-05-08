package com.proyecto_backend.crumbs.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import com.proyecto_backend.crumbs.modelos.Gasto;
import com.proyecto_backend.crumbs.servicios.GastoServicio;


public class GastoControlador {

    @Autowired
    GastoServicio servicio;

    //por cada servicio programo un metodo
    //para recibir  y enviar  respuesta  al cliente

    //funcion controladora apara el servicio de guardar gasto
    public ResponseEntity<?>controladorGuardar(@RequestBody  Gasto datos ){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_gasto(datos)
        );
    }

    // funcion controladora  para el servicio  de listar todos los gastos
    public ResponseEntity<?> controladorListar(){
         return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_gastos()
         );

    }

    // Control para modificar un gasto
    @PutMapping("/{id}")
    public ResponseEntity<?> controladorModificar(@PathVariable Integer id, @RequestBody Gasto datos) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.modificar_gasto(id, datos));
    }

    // Control para eliminar un gasto
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controladorEliminar(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.eliminar_gasto(id));
    }

    // Control para buscar un gasto por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> controladorBuscarPorId(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.buscar_gasto_por_id(id));
    }


}

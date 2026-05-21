package com.proyecto_backend.crumbs.controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import com.proyecto_backend.crumbs.modelos.Categoria;

import com.proyecto_backend.crumbs.servicios.CategoriaServicio;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class CategoriaControlador {

    @Autowired
    CategoriaServicio servicio;

    //por cada servicio programo un metodo
    //para recibir  y enviar  respuesta  al cliente

    //funcion controladora apara el servicio de guardar categoria
    public ResponseEntity<?>controladorGuardar(@RequestBody  Categoria datos ){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_categoria(datos)
        );
    }

    // funcion controladora  para el servicio  de listar todas las categorias
    public ResponseEntity<?> controladorListar(){
         return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_categorias()
         );

    }


    // Control para modificar una categoria
    @PutMapping("/{id}")
    public ResponseEntity<?> controladorModificar(@PathVariable Integer id, @RequestBody Categoria datos) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.modificar_categoria(id, datos));
    }

    // Control para eliminar una categoria
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controladorEliminar(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.eliminar_categoria(id));
    }

    // Control para buscar una categoria por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> controladorBuscarPorId(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.buscar_categoria_por_id(id));
    }

    
}

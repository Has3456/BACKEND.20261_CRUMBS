package com.proyecto_backend.crumbs.controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import com.proyecto_backend.crumbs.modelos.Categoria;
import com.proyecto_backend.crumbs.servicios.CategoriaServicio;


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


}

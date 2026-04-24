package com.proyecto_backend.crumbs.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import com.proyecto_backend.crumbs.modelos.Comercio;
import com.proyecto_backend.crumbs.servicios.ComercioServicio;


public class ComercioControlador {

    @Autowired
    ComercioServicio servicio;

    //por cada servicio programo un metodo
    //para recibir  y enviar  respuesta  al cliente

    //funcion controladora apara el servicio de guardar comercio
    public ResponseEntity<?>controladorGuardar(@RequestBody  Comercio datos ){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_comercio(datos)
        );
    }

    // funcion controladora  para el servicio  de listar todos los comercios
    public ResponseEntity<?> controladorListar(){
            return ResponseEntity.status(HttpStatus.OK).body(
                servicio.listar_comercios()
            );
    
        }
    

    
}

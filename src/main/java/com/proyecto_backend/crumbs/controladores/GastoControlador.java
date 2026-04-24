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


}

package com.proyecto_backend.crumbs.controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

import com.proyecto_backend.crumbs.servicios.MedioPagoServicio;
import com.proyecto_backend.crumbs.modelos.MedioPago;

public class MedioPagoControlador {
    
    @Autowired
    MedioPagoServicio servicio;

    //por cada servicio programo un metodo
    //para recibir  y enviar  respuesta  al cliente 

    //funcion controladora apara el servicio de guardar medio de pago
    public ResponseEntity<?>controladorGuardar(@RequestBody  MedioPago datos ){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_medio_pago(datos)
        );
    }

    // funcion controladora  para el servicio  de listar todos los medios de pago
    public ResponseEntity<?> controladorListar(){
         return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_medios_pago()
         );

    }


}

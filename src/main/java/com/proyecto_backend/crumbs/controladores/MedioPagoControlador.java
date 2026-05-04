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

    /////////////////////////////
    //control para modificar
      @putMapping ("/{id}")
        public ResponseEntity<?>controladorModificar(@pathVariavle integer id, @RequestBody MedioPago datos){
            return ResponseEntity.status(HttpStatus.OK).body(servicio.modificar_medio_pago(id, datos));
        } 


      //////////////////////////////
      /// control para eliminar
       @DeleteMapping("/{id}")
        public ResponseEntity<?>controladorEliminar(@pathVariavle integer id){
            return ResponseEntity.status(HttpStatus.OK).body(servicio.eliminar_medio_pago(id));
        }

        /////////////////////
        //control para buscar por id
        @GetMapping ("/{id}")
        public ResponseEntity<?>controladorBuscarPorId(@pathVariavle integer id){
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscar_medio_pago_por_id(id));
        }

}

package com.proyecto_backend.crumbs.controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;


import com.proyecto_backend.crumbs.servicios.MedioPagoServicio;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto_backend.crumbs.modelos.MedioPago;

@RestController
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
      @PutMapping ("/{id}")
        public ResponseEntity<?>controladorModificar(@PathVariable Integer id, @RequestBody MedioPago datos){
            return ResponseEntity.status(HttpStatus.OK).body(servicio.modificar_medio_pago(id, datos));
        } 


      //////////////////////////////
      /// control para eliminar
       @DeleteMapping("/{id}")
        public ResponseEntity<?>controladorEliminar(@PathVariable Integer id){
            return ResponseEntity.status(HttpStatus.OK).body(servicio.eliminar_medio_pago(id));
        }

        /////////////////////
        //control para buscar por id
        @GetMapping ("/{id}")
        public ResponseEntity<?>controladorBuscarPorId(@PathVariable Integer id){
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscar_medio_pago_por_id(id));
        }

}

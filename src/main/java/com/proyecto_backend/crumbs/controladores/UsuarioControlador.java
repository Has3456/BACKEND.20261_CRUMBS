package com.proyecto_backend.crumbs.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;



import com.proyecto_backend.crumbs.modelos.Usuario;
import com.proyecto_backend.crumbs.servicios.UsuarioServicio;


public class UsuarioControlador {
    
   @Autowired

    UsuarioServicio servicio; 

    //por cada servicio programo un metodo 
    //para recibir  y enviar  respuesta  al cliente 

    //funcion controladora apara el servicio de guardar usuario
    public ResponseEntity<?>controladorGuardar(@RequestBody  Usuario datos ){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_usuario(datos)
        );
    }
    

    // funcion controladora  para el servicio  de listar todos los ususarios
    public ResponseEntity<?> controladorListar(){
         return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_usuarios()
         );

    }


}
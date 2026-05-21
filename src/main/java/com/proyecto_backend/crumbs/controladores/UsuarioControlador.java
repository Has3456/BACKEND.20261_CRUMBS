package com.proyecto_backend.crumbs.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

import com.proyecto_backend.crumbs.modelos.Usuario;
import com.proyecto_backend.crumbs.servicios.UsuarioServicio;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; // Añadido
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController         
@RequestMapping("/api/crumbs/usuarios")

public class UsuarioControlador {
    
   @Autowired
    UsuarioServicio servicio; 


    // funcion controladora para el servicio de guardar usuario
    @PostMapping // AÑADIDO: Ahora responde a peticiones POST
    public ResponseEntity<?> controladorGuardar(@RequestBody Usuario datos ){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_usuario(datos)
        );
    }

    
    
    // funcion controladora para el servicio de listar todos los usuarios
    @GetMapping // AÑADIDO: Ahora responde a peticiones GET
    public ResponseEntity<?> controladorListar(){
         return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_usuarios()
         );
    }

    // control para modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> controladorModificar(@PathVariable Integer id, @RequestBody Usuario datos){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.modificar_usuario(id, datos));
    }  

    // control para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controladorEliminar(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.eliminar_usuario(id));
    }  

    // control para buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> controladorBuscarPorId(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.buscar_usuario_por_id(id));
    }
}
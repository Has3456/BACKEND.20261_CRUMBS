package com.proyecto_backend.crumbs.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.proyecto_backend.crumbs.modelos.Usuario;
import com.proyecto_backend.crumbs.servicios.UsuarioServicio;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; // Verifica que esté importado
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController     
@RequestMapping("/api/crumbs/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioControlador {
    
    @Autowired
    UsuarioServicio servicio; 

    // 🟢 DEJA SOLO ESTA FUNCIÓN DE GUARDAR CON SU @PostMapping
    @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody Usuario datos ){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_usuario(datos)
        );
    }
    
    // 🟢 DEJA SOLO ESTA FUNCIÓN DE LISTAR CON SU @GetMapping
    @GetMapping
    public ResponseEntity<?> controladorListar(){
         return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_usuarios()
         );
    }

    // El resto de tus métodos abajo (Modificar, Eliminar, Buscar) se quedan igual...
    @PutMapping("/{id}")
    public ResponseEntity<?> controladorModificar(@PathVariable Integer id, @RequestBody Usuario datos){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.modificar_usuario(id, datos));
    }  

    @DeleteMapping("/{id}")
    public ResponseEntity<?> controladorEliminar(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.eliminar_usuario(id));
    }   

    @GetMapping("/{id}")
    public ResponseEntity<?> controladorBuscarPorId(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.buscar_usuario_por_id(id));
    }
}
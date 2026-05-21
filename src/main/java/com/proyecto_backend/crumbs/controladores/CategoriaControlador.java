package com.proyecto_backend.crumbs.controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import com.proyecto_backend.crumbs.modelos.Categoria;
import com.proyecto_backend.crumbs.servicios.UsuarioServicio;

import org.springframework.web.bind.annotation.RestController;

                                                                                                                                                                                                                                                                                 
import com.proyecto_backend.crumbs.servicios.CategoriaServicio;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/crumbs/categorias")
public class CategoriaControlador  {

    @Autowired
    CategoriaServicio servicio;

    @Autowired
    CategoriaServicio categoriaServicio;

    @Autowired
    UsuarioServicio usuarioServicio;

    // funcion controladora  para el servicio  de listar todas las categorias
    public ResponseEntity<?> controladorListar(){
         return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_categorias()
         );

    }



// POST: Para guardar una nueva categoría
    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> controladorGuardar(@PathVariable Integer usuarioId, @RequestBody Categoria datos) {
        // Aquí llamarías al servicio pasando el usuarioId para asociar
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_categoria(usuarioId, datos) 
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

    

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> controladorListarPorUsuario(@PathVariable Integer usuarioId) {
    return ResponseEntity.status(HttpStatus.OK).body(
        servicio.listar_categorias_por_usuario(usuarioId)
    );
}

    
}

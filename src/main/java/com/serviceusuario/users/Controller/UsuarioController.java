package com.serviceusuario.users.Controller;

import com.serviceusuario.users.Modelo.Usuarios;
import com.serviceusuario.users.Service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioServicio usuarioServicio;

    @Autowired
    public UsuarioController(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    // 1. Registrar usuario
    @PostMapping("/registro")
    public ResponseEntity<Usuarios> registrarUsuario(@RequestBody Usuarios usuario) {
        Usuarios creado = usuarioServicio.registrar(usuario);
        return ResponseEntity.ok(creado);
    }

    // 2. Obtener perfil por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> obtenerPerfil(@PathVariable int id) {
        Usuarios usuario = usuarioServicio.obtenerPorId(id);
        return ResponseEntity.ok(usuario);
    }

    // 3. Listar todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuarios>> listarUsuarios() {
        List<Usuarios> usuarios = usuarioServicio.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    // 4. Obtener estado de suscripción por ID
    @GetMapping("/{id}/suscripcion")
    public ResponseEntity<Boolean> obtenerEstadoSuscripcion(@PathVariable int id) {
        boolean estado = usuarioServicio.obtenerEstadoSuscripcion(id);
        return ResponseEntity.ok(estado);
    }

    // 5. Modificar usuario completo
    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> modificarUsuario(@PathVariable int id, @RequestBody Usuarios usuario) {
        Usuarios actualizado = usuarioServicio.modificarUsuario(id, usuario);
        return ResponseEntity.ok(actualizado);
    }

    // 6. Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable int id) {
        usuarioServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // 7. Modificar solo la suscripción
    @PutMapping("/{id}/suscripcion")
    public ResponseEntity<Usuarios> modificarSuscripcion(@PathVariable int id, @RequestBody boolean nuevaSuscripcion) {
        Usuarios actualizado = usuarioServicio.modificarSuscripcion(id, nuevaSuscripcion);
        return ResponseEntity.ok(actualizado);
    }
}

package com.serviceusuario.users.Controller;

import com.serviceusuario.users.Modelo.Usuarios.EstadoSuscripcion;
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

    @PostMapping("/registro")
    public ResponseEntity<Usuarios> registrarUsuario(@RequestBody Usuarios usuario) {
        Usuarios creado = usuarioServicio.registrar(usuario);
        return ResponseEntity.ok(creado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> obtenerPerfil(@PathVariable int id) {
        Usuarios usuario = usuarioServicio.obtenerPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuarios>> listarUsuarios() {
        List<Usuarios> usuarios = usuarioServicio.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}/suscripcion")
    public ResponseEntity<EstadoSuscripcion> obtenerEstadoSuscripcion(@PathVariable int id) {
        EstadoSuscripcion estado = usuarioServicio.obtenerEstadoSuscripcion(id);
        return ResponseEntity.ok(estado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> modificarUsuario(@PathVariable int id, @RequestBody Usuarios usuario) {
        Usuarios actualizado = usuarioServicio.modificarUsuario(id, usuario);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable int id) {
        usuarioServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/suscripcion")
    public ResponseEntity<Usuarios> modificarSuscripcion(@PathVariable int id, @RequestBody String nuevaSuscripcion) {
        EstadoSuscripcion estadoEnum;
        try {
            estadoEnum = EstadoSuscripcion.valueOf(nuevaSuscripcion.toUpperCase());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build(); // Estado inválido
        }

        Usuarios actualizado = usuarioServicio.modificarSuscripcion(id, estadoEnum);
        return ResponseEntity.ok(actualizado);
    }
}


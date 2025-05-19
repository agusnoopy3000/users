package com.serviceusuario.users.Service;

import com.serviceusuario.users.Modelo.Usuarios.EstadoSuscripcion;
import com.serviceusuario.users.Modelo.Usuarios;
import com.serviceusuario.users.Repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServicioImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuarios registrar(Usuarios usuario) {
        return usuarioRepository.save(usuario);
    }
    //Obtener usuario por ID
    @Override
    public Usuarios obtenerPorId(int id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }
    //Listar TODOS los usuarios
    @Override
    public List<Usuarios> listarTodos() {
        return usuarioRepository.findAll();
    }
    //Obtener estado de suscripcion por ID

    @Override
    public EstadoSuscripcion obtenerEstadoSuscripcion(int id) {
        return obtenerPorId(id).getEstadoSuscripcion();
    }

    @Override
    public Usuarios modificarUsuario(int id, Usuarios usuarioActualizado) {
        Usuarios existente = obtenerPorId(id);
        existente.setNombreUsuario(usuarioActualizado.getNombreUsuario());
        existente.setCorreo(usuarioActualizado.getCorreo());
        existente.setContrasenia(usuarioActualizado.getContrasenia());
        existente.setRol(usuarioActualizado.getRol());
        existente.setEstadoCuenta(usuarioActualizado.isEstadoCuenta());
        existente.setEstadoSuscripcion(usuarioActualizado.getEstadoSuscripcion());
        return usuarioRepository.save(existente);
    }
    // Eliminar usuario por id
    @Override
    public void eliminar(int id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar. Usuario no encontrado con ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }
    // Modificar suscripcion por id de usuario y seteo de nueva suscripcion(ACTIVA,DESACTIVA...)

    @Override
    public Usuarios modificarSuscripcion(int id, EstadoSuscripcion nuevaSuscripcion) {
        Usuarios usuario = obtenerPorId(id);
        usuario.setEstadoSuscripcion(nuevaSuscripcion);
        return usuarioRepository.save(usuario);
    }
    //Listar Usuarios por rol

    public List<Usuarios> listarPorRol(String rol) {
        return usuarioRepository.findByRol(rol);
    }

   //Listar Usuarios con Estado de cuenta true
    public List<Usuarios> listarActivos() {
        return usuarioRepository.findByEstadoCuenta(true);
    }
}


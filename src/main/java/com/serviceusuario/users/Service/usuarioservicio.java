package com.serviceusuario.users.Service;
import com.serviceusuario.users.Modelo.Usuarios;
import java.util.List;

public interface UsuarioServicio {//Interfaz para el servicio
    
    Usuarios registrar(Usuarios usuario);
    Usuarios obtenerPorId(int id);
    List<Usuarios> listarTodos();
    boolean obtenerEstadoSuscripcion(int id);
    Usuarios modificarUsuario(int id, Usuarios usuario);
    void eliminar(int id);
    Usuarios modificarSuscripcion(int id, boolean nuevaSuscripcion);
}
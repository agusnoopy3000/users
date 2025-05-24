package com.serviceusuario.users.Service;

import com.serviceusuario.users.Modelo.Usuarios;
import com.serviceusuario.users.Modelo.Usuarios.EstadoSuscripcion;

import java.util.List;

public interface UsuarioServicio {
    List<Usuarios> buscarUsuarios(String rol, Boolean estadoCuenta, Usuarios.EstadoSuscripcion estadoSuscripcion);
    List<Usuarios> buscarPorEstadosSuscripcion(List<EstadoSuscripcion> estados);
    


    Usuarios registrar(Usuarios usuario);
    
    Usuarios obtenerPorId(int id);
    
    List<Usuarios> listarTodos();
    
    EstadoSuscripcion obtenerEstadoSuscripcion(int id); // cambiado de String a enum
    
    Usuarios modificarUsuario(int id, Usuarios usuario);
    
    void eliminar(int id);
    
    Usuarios modificarSuscripcion(int id, EstadoSuscripcion nuevaSuscripcion); // cambiado a enum
}

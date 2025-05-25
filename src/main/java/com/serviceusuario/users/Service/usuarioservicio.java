package com.serviceusuario.users.Service;

import java.util.List;

import com.serviceusuario.users.Model.Usuarios;
import com.serviceusuario.users.Model.Usuarios.EstadoSuscripcion;

public interface UsuarioServicio {
    List<Usuarios> buscarUsuarios(String rol, Boolean estadoCuenta, Usuarios.EstadoSuscripcion estadoSuscripcion);

    List<Usuarios> buscarPorEstadosSuscripcion(List<EstadoSuscripcion> estados);
    
    Usuarios registrar(Usuarios usuario);
    
    Usuarios obtenerPorId(int id);
    
    List<Usuarios> listarTodos();
    
    EstadoSuscripcion obtenerEstadoSuscripcion(int id); 
    
    Usuarios modificarUsuario(int id, Usuarios usuario);
    
    void eliminar(int id);
    
    Usuarios modificarSuscripcion(int id, EstadoSuscripcion nuevaSuscripcion); 
}

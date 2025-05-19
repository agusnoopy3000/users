package com.serviceusuario.users.Repositorio;

import com.serviceusuario.users.Modelo.Usuarios;
import com.serviceusuario.users.Modelo.Usuarios.EstadoSuscripcion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {

    // Buscar usuario por nombre de usuario (único)
    Optional<Usuarios> findByNombreUsuario(String nombreUsuario);

    // Buscar usuario por correo (único)
    Optional<Usuarios> findByCorreo(String correo);

    // Buscar usuario por correo y contraseña (por ejemplo, login)
    Optional<Usuarios> findByCorreoAndContrasenia(String correo, String contrasenia);

    // Buscar todos los usuarios con un rol específico
    List<Usuarios> findByRol(String rol);

    // Buscar todos los usuarios con un estado de cuenta específico
    List<Usuarios> findByEstadoCuenta(boolean estadoCuenta);

    // Buscar todos los usuarios con estado de suscripción específico
    List<Usuarios> findByEstadoSuscripcion(EstadoSuscripcion estadoSuscripcion);
    //Buscar por estados de Suscripcion.
    List<Usuarios> findByEstadoSuscripcionIn(List<EstadoSuscripcion> estados);



    
}

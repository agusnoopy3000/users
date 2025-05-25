package com.serviceusuario.users.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.serviceusuario.users.Model.Usuarios;
import com.serviceusuario.users.Model.Usuarios.EstadoSuscripcion;

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

    @Query("SELECT u FROM Usuarios u WHERE " +
           "(:rol IS NULL OR u.rol = :rol) AND " +
           "(:estadoCuenta IS NULL OR u.estadoCuenta = :estadoCuenta) AND " +
           "(:estadoSuscripcion IS NULL OR u.estadoSuscripcion = :estadoSuscripcion)") //Condiciones de filtros 
    List<Usuarios> buscarUsuariosCondicionales(
        @Param("rol") String rol,
        @Param("estadoCuenta") Boolean estadoCuenta,
        @Param("estadoSuscripcion") Usuarios.EstadoSuscripcion estadoSuscripcion
    );



    
}

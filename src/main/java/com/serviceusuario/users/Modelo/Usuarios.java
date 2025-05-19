package com.serviceusuario.users.Modelo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_usuario", nullable = false, unique = true)
    private String nombreUsuario;

    @Column(name = "pnombre", nullable = false)
    private String pnombre;

    @Column(name = "snombre", nullable = false)
    private String snombre;

    @Column(name = "appaterno", nullable = false)
    private String appaterno;

    @Column(name = "apmaterno", nullable = false)
    private String apmaterno;

    @Column(name = "correo", nullable = false, unique = true)
    private String correo;

    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;

    @Column(name = "rol", nullable = false)
    private String rol;

    @Column(name = "estado_cuenta", nullable = false)
    private boolean estadoCuenta;

   @Enumerated(EnumType.STRING)
    private EstadoSuscripcion estadoSuscripcion;
    public enum EstadoSuscripcion {
        ACTIVA,
        DESACTIVADA,
        EXPIRADA,
        ERROR
    }

}

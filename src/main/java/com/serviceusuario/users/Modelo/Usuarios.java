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

    @Column(name = "correo", nullable = false, unique = true)
    private String correo;

    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;

    @Column(name = "rol", nullable = false)
    private String rol;

    @Column(name = "estado_cuenta", nullable = false)
    private boolean estadoCuenta;

    @Column(name = "estado_suscripcion", nullable = false)
    private boolean estadoSuscripcion;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_vencimiento_suscripcion", nullable = false)
    private Date fechaVencimientoSuscripcion;

}

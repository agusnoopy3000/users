package com.serviceusuario.users.Model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Entity // Define la clase como una entidad JPA
@Table(name = "Usuarios") // Nombre tabla base de datos
@Data // Generacion de metodos bases.
@AllArgsConstructor //Generacion de un contructor por cada campo de la clase
@NoArgsConstructor // Generacion de contructor sin argumentos 
public class Usuarios {

    @Id // Definicion de identificador primario.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generara el id automaticamente
    private int id;

    @Column(name = "nombre_usuario", nullable = false, unique = true) // No puede ser nulo. UNICO.
    private String nombreUsuario;

    @Column(name = "pnombre", nullable = false) // No puede ser nulo
    private String pnombre;

    @Column(name = "snombre", nullable = false) // No puede ser nulo
    private String snombre;

    @Column(name = "appaterno", nullable = false) // No puede ser nulo
    private String appaterno;

    @Column(name = "apmaterno", nullable = false) // No puede ser nulo
    private String apmaterno;

    @Column(name = "correo", nullable = false, unique = true)// Unico y no puede ser nulo
    private String correo;

    @Column(name = "contrasenia", nullable = false)//No puede ser nulo
    private String contrasenia;

    @Column(name = "rol", nullable = false) // No puede ser nulo
    private String rol;

    @Column(name = "estado_cuenta", nullable = false) // No puede ser nulo
    private boolean estadoCuenta;

   @Enumerated(EnumType.STRING)
    private EstadoSuscripcion estadoSuscripcion; // Esta columnda define los estados de suscripcion.
    public enum EstadoSuscripcion {
        ACTIVA,
        DESACTIVADA,
        EXPIRADA,
        ERROR
    }

}

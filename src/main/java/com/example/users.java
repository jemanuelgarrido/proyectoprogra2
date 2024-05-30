package com.example;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//DTO PARA USUARIOS
@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class users {
    @Id
    @GeneratedValue
    private Integer id_user;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "correo_electronico")
    private String email;
}

package com.example;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "commentary")
public class commentary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String nombre;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String comentario;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public commentary() {
        this.fecha = new Date(); // Establecer la fecha actual al crear un nuevo comentario
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}

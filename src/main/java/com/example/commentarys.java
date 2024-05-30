package com.example;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
//DTO PARA COMENTARIOS
@Entity
@Table(name = "commentarys")//Estamos mappeando la tabla commentarys
@Data//getter and setter y los argumentos
@AllArgsConstructor
@NoArgsConstructor
public class commentarys {
    @Id
    @GeneratedValue
    private Integer id_comentario;
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "fecha_comentario")
    private Date fecha;
    @ManyToOne//relacion de muchos a uno, es decir pueden haber muchos usuarios de un solo proy.
    @JoinColumn(name = "id_usuario")
    private users id_user;

}

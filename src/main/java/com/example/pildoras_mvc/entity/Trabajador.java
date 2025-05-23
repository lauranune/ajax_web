package com.example.pildoras_mvc.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    @ManyToOne
    @JoinColumn(name="departamento_id")
    private Departamento departamento;
}

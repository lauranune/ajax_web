package com.example.pildoras_mvc.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class TrabajadorDto implements Serializable {
    private Long id;

    @NotEmpty(message = "El nombre no debe estar vacío")
    @Size(min = 2, max = 50)
    private String nombre;

    @NotEmpty(message = "El apellido no debe estar vacío")
    @Size(min = 2, max = 50)
    private String apellido;

    private Long departamentoId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public Long getDepartamentoId() { return departamentoId; }
    public void setDepartamentoId(Long departamentoId) { this.departamentoId = departamentoId; }
}

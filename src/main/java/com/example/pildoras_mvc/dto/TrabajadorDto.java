package com.example.pildoras_mvc.dto;

import java.io.Serializable;

public class TrabajadorDto implements Serializable {
    private Long id;
    private String nombre;
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

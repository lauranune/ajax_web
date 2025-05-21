package com.example.pildoras_mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.example.pildoras_mvc.entity.Trabajador}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrabajadorDto implements Serializable {
    private Long id;
    private String nombre;
    private String apellido;
    private DepartamentoDto departamento;

    /**
     * DTO for {@link com.example.pildoras_mvc.entity.Departamento}
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DepartamentoDto implements Serializable {
        private Long id;
        private String nombre_dept;
    }
}
package com.example.pildoras_mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoDto implements Serializable {
    private int id;
    private String nombre;

}

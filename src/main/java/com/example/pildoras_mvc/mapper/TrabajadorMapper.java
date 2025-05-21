package com.example.pildoras_mvc.mapper;

import com.example.pildoras_mvc.dto.TrabajadorDto;
import com.example.pildoras_mvc.entity.Trabajador;

import java.util.List;

public interface TrabajadorMapper {

    Trabajador toTrabajador(Trabajador trabajadorDto);

    TrabajadorDto toTrabajadorDto(Trabajador trabajador);

    List<TrabajadorDto> toTrabajadorDto(List<Trabajador> trabajador);

    void updateTrabajador(Trabajador trabajador, TrabajadorDto trabajadorDto);
}

package com.example.pildoras_mvc.mapper;

import com.example.pildoras_mvc.dto.DepartamentoDto;
import com.example.pildoras_mvc.dto.TrabajadorDto;
import com.example.pildoras_mvc.entity.Departamento;
import com.example.pildoras_mvc.entity.Trabajador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrabajadorMapper {

    @Mapping(target = "departamento.id", source = "departamentoId")
    Trabajador toEntity(TrabajadorDto dto);

    @Mapping(source = "departamento.id", target = "departamentoId")
    TrabajadorDto toTrabajadorDto(Trabajador entity);

    List<TrabajadorDto> toTrabajadorDto(List<Trabajador> trabajadores);

    @Mapping(target = "departamento.id", source = "departamentoId")
    void updateTrabajador(@MappingTarget Trabajador trabajador, TrabajadorDto dto);

    //    Trabajador toEntity(TrabajadorDto dto);
//
//    TrabajadorDto toTrabajadorDto(Trabajador entity);
//
//    List<TrabajadorDto> toTrabajadorDto(List<Trabajador> trabajadores);
//
//    @Mapping(target = "departamento.id", source = "departamentoId")
//    void updateTrabajador(@MappingTarget Trabajador trabajador, TrabajadorDto dto);
}
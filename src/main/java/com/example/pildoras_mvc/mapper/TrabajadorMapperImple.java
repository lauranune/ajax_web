package com.example.pildoras_mvc.mapper;

import com.example.pildoras_mvc.dto.TrabajadorDto;
import com.example.pildoras_mvc.entity.Trabajador;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TrabajadorMapperImple implements TrabajadorMapper {

    @Override
    public Trabajador toTrabajador(Trabajador trabajadorDto) {
        if(trabajadorDto == null){
            return null;
        }

        Trabajador trabajador = new Trabajador();
        trabajador.setId(trabajadorDto.getId());
        trabajador.setNombre(trabajadorDto.getNombre());
        trabajador.setApellido(trabajadorDto.getApellido());

        return trabajador;

    }

    @Override
    public TrabajadorDto toTrabajadorDto(Trabajador trabajador) {

        if (trabajador == null) {
            return null;
        };
        TrabajadorDto trabajadorDto = new TrabajadorDto();
        trabajadorDto.setId(trabajador.getId());
        trabajadorDto.setNombre(trabajador.getNombre());
        trabajadorDto.setApellido(trabajador.getApellido());

        return trabajadorDto;
    }

    @Override
    public List<TrabajadorDto> toTrabajadorDto(List<Trabajador> trabajadores) {
        if (trabajadores == null) {
            return null;
        }
        List<TrabajadorDto> list = new ArrayList<>(trabajadores.size());
        for (Trabajador trabajador : trabajadores) {
            list.add(toTrabajadorDto(trabajador));
        }

        return list;
    }

    @Override
    public void updateTrabajador(Trabajador trabajador, TrabajadorDto trabajadorDto) {
        if (trabajadorDto == null) {
            return;
        }
        trabajador.setId(trabajadorDto.getId());
        trabajador.setNombre(trabajadorDto.getNombre());
        trabajador.setApellido(trabajadorDto.getApellido());

    }
}

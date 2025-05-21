package com.example.pildoras_mvc.service;

import com.example.pildoras_mvc.dto.TrabajadorDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajadorServiceImple implements TrabajadorService {

    @Override
    public TrabajadorDto save(TrabajadorDto trabajadorDto) {
        return null;
    }

    @Override
    public List<TrabajadorDto> findAll() {
        return List.of();
    }

    @Override
    public TrabajadorDto findById(Long id) {
        return null;
    }

    @Override
    public TrabajadorDto update(TrabajadorDto trabajadorDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

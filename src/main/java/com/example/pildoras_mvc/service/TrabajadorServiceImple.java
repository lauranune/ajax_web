package com.example.pildoras_mvc.service;

import com.example.pildoras_mvc.dto.TrabajadorDto;
import com.example.pildoras_mvc.entity.Trabajador;
import com.example.pildoras_mvc.repository.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajadorServiceImple {
    @Autowired
    private TrabajadorRepository trabajadorRepository;
    public TrabajadorDto save(TrabajadorDto trabajadorDto) {
        return null;
    }

    public List<TrabajadorDto> findAll() {
        return List.of();
    }

    public Trabajador findById(Long id) {
        Trabajador t = trabajadorRepository.findById(id).orElse(null);
        return t;
    }

    public TrabajadorDto update(TrabajadorDto trabajadorDto) {
        return null;
    }

    public void delete(Long id) {

    }
}

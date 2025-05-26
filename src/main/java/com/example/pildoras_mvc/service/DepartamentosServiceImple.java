package com.example.pildoras_mvc.service;

import com.example.pildoras_mvc.dto.DepartamentoDto;
import com.example.pildoras_mvc.entity.Departamento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentosServiceImple implements DepartamentoService {
    @Override
    public DepartamentoDto save(DepartamentoDto departamentoDto) {
        return null;
    }

    @Override
    public List<Departamento> findAll() {
        return List.of();
    }

    @Override
    public Departamento findById(int id) {
        return null;
    }

    @Override
    public void save(Departamento departamento) {

    }

    @Override
    public void delete(Departamento departamento) {

    }
}

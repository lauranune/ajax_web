package com.example.pildoras_mvc.service;

import com.example.pildoras_mvc.dto.DepartamentoDto;
import com.example.pildoras_mvc.entity.Departamento;

import java.util.List;

public interface DepartamentoService {
    public DepartamentoDto save(DepartamentoDto departamentoDto);
    public List<Departamento> findAll();
    public Departamento findById(int id);
    public void save(Departamento departamento);
    public void delete(Departamento departamento);

}

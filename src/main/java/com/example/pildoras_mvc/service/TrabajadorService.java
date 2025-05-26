package com.example.pildoras_mvc.service;

import com.example.pildoras_mvc.dto.TrabajadorDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TrabajadorService {

   public TrabajadorDto save(TrabajadorDto trabajadorDto);
   public List<TrabajadorDto> findAll();
   public TrabajadorDto findById(Long id);
   public TrabajadorDto update(TrabajadorDto trabajadorDto);
   public void delete(Long id);
}

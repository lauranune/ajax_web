package com.example.pildoras_mvc.repository;

import com.example.pildoras_mvc.entity.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MvcRepository extends JpaRepository<Trabajador, Long> {

}
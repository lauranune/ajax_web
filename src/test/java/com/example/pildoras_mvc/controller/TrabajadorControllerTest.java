package com.example.pildoras_mvc.controller;

import com.example.pildoras_mvc.controlador.TrabajadorController;
import com.example.pildoras_mvc.dto.TrabajadorDto;
import com.example.pildoras_mvc.entity.Departamento;
import com.example.pildoras_mvc.entity.Trabajador;
import com.example.pildoras_mvc.mapper.TrabajadorMapper;
import com.example.pildoras_mvc.repository.DepartamentoRepository;
import com.example.pildoras_mvc.repository.TrabajadorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TrabajadorController.class)
public class TrabajadorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TrabajadorRepository trabajadorRepository;

   @MockitoBean
   private DepartamentoRepository departamentoRepository;

   @MockitoBean
   private TrabajadorMapper trabajadorMapper;

    @Test
    public void testMostrarFormulario() throws Exception {
        when(departamentoRepository.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/formulario"))
                .andExpect(status().isOk())
                .andExpect(view().name("formulario :: contenido"))
                .andExpect(model().attributeExists("trabajador"))
                .andExpect(model().attributeExists("departamentos"));
    }

    @Test
    public void testNuevoTrabajadorCorrecto() throws Exception {
        mockMvc.perform(post("/nuevo")
                .param("nombre", "lola")
                .param("apellido", "menta")
                .param("departamentoId", "1")
                .param("departamentoNombre", "informática"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    @Test
    public void testNuevoTrabajadorIncorrecto() throws Exception {
        mockMvc.perform(post("/nuevo")
                .param("nombre", "")
                .param("apellido", "")
                .param("departamento", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("formulario :: contenido"))
                .andExpect(model().attributeHasFieldErrors("trabajador","nombre", "apellido", "departamentoId"))
                .andExpect(model().attributeExists("departamentos"));
    }

    @Test
    public void testBorrarTrabajador() throws Exception {
        mockMvc.perform(get("/borrar/{id}", 1))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    @Test
    public void testEditarTrabajador() throws Exception {
        Departamento departamento = new Departamento();
        departamento.setId(1L);
        departamento.setNombre("RRHH");

        Trabajador trabajador = new Trabajador(1L, "Lola", "Menta", departamento);
        TrabajadorDto dto= new TrabajadorDto();
        dto.setNombre("Lola");
        dto.setApellido("Menta");

        when(trabajadorRepository.findById(1L)).thenReturn(Optional.of(trabajador));
        when(trabajadorMapper.toTrabajadorDto(trabajador)).thenReturn(dto);
        when(departamentoRepository.findAll()).thenReturn(List.of());

        mockMvc.perform(get("/editar").param("id","1"))
                .andExpect(status().isOk())
                .andExpect(view().name("editar :: modalEditar"))
                .andExpect(model().attributeExists("trabajador"))
                .andExpect(model().attributeExists("departamentos"));
    }
}

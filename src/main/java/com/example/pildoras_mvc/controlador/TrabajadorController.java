package com.example.pildoras_mvc.controlador;

import com.example.pildoras_mvc.dto.TrabajadorDto;
import com.example.pildoras_mvc.entity.Departamento;
import com.example.pildoras_mvc.entity.Trabajador;
import com.example.pildoras_mvc.mapper.TrabajadorMapper;
import com.example.pildoras_mvc.repository.TrabajadorRepository;
import com.example.pildoras_mvc.repository.DepartamentoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class TrabajadorController {

    @Autowired
    private TrabajadorRepository trabajadorRepository;
    @Autowired
    private DepartamentoRepository departamentoRepository;
    @Autowired
    private TrabajadorMapper trabajadorMapper;

    @GetMapping("/")
    public String index(Model model) {
      List <Trabajador> trabajadores = trabajadorRepository.findAll();
      List <TrabajadorDto> dtos= trabajadores.stream()
              .map(trabajadorMapper::toTrabajadorDto)
              .toList();
      model.addAttribute("trabajadores", dtos);
      return "index";
  }

  @GetMapping("/formulario")
  public String mostrarFormulario(Model model) {
    model.addAttribute("trabajador", new TrabajadorDto());

    List<Departamento> departamentos = departamentoRepository.findAll();
    model.addAttribute("departamentos", departamentos);
    return "formulario :: contenido";
  }

    @PostMapping("/nuevo")
    public String nuevo(@Valid @ModelAttribute("trabajador") TrabajadorDto trabajadorDto, BindingResult result, Model model) {

        if(result.hasErrors()){
            model.addAttribute("departamentos", departamentoRepository.findAll());
            return "formulario :: contenido";
        }

        Trabajador trabajador = trabajadorMapper.toEntity(trabajadorDto);
        trabajadorRepository.save(trabajador);
        return "redirect:/";
    }

  @GetMapping("/borrar/{id}")
  public String borrar(@PathVariable Long id){
    trabajadorRepository.deleteById(id);
    return "redirect:/";
  }

  @GetMapping("/editar")
  public String mostrarEditar(@RequestParam Long id, Model model){
    Trabajador trabajador= trabajadorRepository.findById(id)
            .orElse(new Trabajador());
    TrabajadorDto dto = trabajadorMapper.toTrabajadorDto(trabajador);

    List<Departamento> departamentos = departamentoRepository.findAll();
    model.addAttribute("trabajador", dto);
    model.addAttribute("departamentos", departamentos);
    return "editar :: modalEditar";
  }

  @PostMapping("/editar")
  public String editar(@ModelAttribute("trabajador") @ Valid TrabajadorDto trabajadorDto, BindingResult result, Model model) {

        if(result.hasErrors()){
          model.addAttribute("departamentos", departamentoRepository.findAll());
          return "editar :: modalEditar";
      }

        Optional<Trabajador> optional = trabajadorRepository.findById(trabajadorDto.getId());
      if (optional.isPresent()) {
          Trabajador trabajador = optional.get();
          trabajadorMapper.updateTrabajador(trabajador, trabajadorDto);
          trabajadorRepository.save(trabajador);
      }
    return "redirect:/";
  }
}
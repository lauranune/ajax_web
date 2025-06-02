package com.example.pildoras_mvc.controlador;

import com.example.pildoras_mvc.dto.TrabajadorDto;
import com.example.pildoras_mvc.entity.Departamento;
import com.example.pildoras_mvc.entity.Trabajador;
import com.example.pildoras_mvc.mapper.TrabajadorMapper;
import com.example.pildoras_mvc.repository.TrabajadorRepository;
import com.example.pildoras_mvc.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
      model.addAttribute("trabajadores", trabajadores);
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
    public String nuevo(@ModelAttribute TrabajadorDto trabajadorDto) {
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
  @ResponseBody
  public ResponseEntity<String> editar(@RequestBody TrabajadorDto dto) {
      Optional<Trabajador> optional = trabajadorRepository.findById(dto.getId());
      if (optional.isPresent()) {
          Trabajador trabajador = optional.get();
          trabajadorMapper.updateTrabajador(trabajador, dto);
          trabajadorRepository.save(trabajador);
      }
    return ResponseEntity.ok("Guardado");
  }
}
package com.example.pildoras_mvc.controlador;

import com.example.pildoras_mvc.entity.Departamento;
import com.example.pildoras_mvc.entity.Trabajador;
import com.example.pildoras_mvc.repository.TrabajadorRepository;
import com.example.pildoras_mvc.repository.DepartamentoRepository;
import com.example.pildoras_mvc.service.DepartamentoService;
import com.example.pildoras_mvc.service.TrabajadorService;
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
    private TrabajadorService trabajadorService;
    @Autowired
    private DepartamentoService departamentoService;

  @GetMapping("/")
    public String index(Model model) {
      List <Trabajador> trabajadores = trabajadorRepository.findAll();
      model.addAttribute("trabajadores", trabajadores);
      return "index";
  }

  @GetMapping("/formulario")
  public String mostrarFormulario(Model model) {
    model.addAttribute("trabajador", new Trabajador());

    List<Departamento> departamentos = departamentoRepository.findAll();
    model.addAttribute("departamentos", departamentos);
    return "formulario :: contenido";
  }

  @PostMapping("/nuevo")
  public String nuevo(Trabajador trabajador) {
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
    List<Departamento> departamentos = departamentoRepository.findAll();

    model.addAttribute("trabajador", trabajador);
    model.addAttribute("departamentos", departamentos);
    return "editar :: modalEditar";
  }

//  @GetMapping("/editar")
//  public ModelAndView mostrarEditar(@RequestParam Long id) {
//    Trabajador trabajador = trabajadorRepository.findById(id)
//            .orElse(new Trabajador());
//    List<Departamento> departamentos = departamentoService.findAll();
//
//    ModelAndView mav = new ModelAndView("editar :: modalEditar");
//    mav.addObject("trabajador", trabajador);
//    mav.addObject("departamentos", departamentos);
//    return mav;
//  }

  @PostMapping("/editar")
  @ResponseBody
  public ResponseEntity<String> editar(@RequestBody Trabajador trabajador) {
    trabajadorRepository.save(trabajador);
    return ResponseEntity.ok("Guardado");
  }
}
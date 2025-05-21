package com.example.pildoras_mvc.controlador;

import com.example.pildoras_mvc.entity.Trabajador;
import com.example.pildoras_mvc.repository.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TrabajadorController {

    @Autowired
    private TrabajadorRepository trabajadorRepository;

  @GetMapping("/")
    public String index(Model model) {
      List <Trabajador> trabajadores = trabajadorRepository.findAll();
      model.addAttribute("trabajadores", trabajadores);
      return "index";
  }

  @GetMapping("/formulario")
  public String mostrarFormulario(Model model) {
    model.addAttribute("trabajador", new Trabajador());
    return "formulario :: contenido";
  }

  @PostMapping("/formulario")
  @ResponseBody
  public String nuevoJson(@RequestBody Trabajador trabajador) {
    trabajadorRepository.save(trabajador);
    return "OK";
  }



  @PostMapping("/borrar/{id}")
  public String borrar(@PathVariable Long id){
    trabajadorRepository.deleteById(id);
    return "redirect:/";
  }

}

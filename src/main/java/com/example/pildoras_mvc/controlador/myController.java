package com.example.pildoras_mvc.controlador;

import com.example.pildoras_mvc.entity.Trabajador;
import com.example.pildoras_mvc.repository.MvcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class myController {

    @Autowired
    private MvcRepository mvcRepository;

  @GetMapping("/")
    public String index(Model model) {
      List <Trabajador> trabajadores = mvcRepository.findAll();
      model.addAttribute("trabajadores", trabajadores);
      return "index";
  }

  @PostMapping("/nuevo")
    public String nuevo(Trabajador trabajador, Model model) {
      mvcRepository.save(new Trabajador());
      return "redirect:/";
  }

  @PostMapping("/borrar/{id}")
  public String borrar(@PathVariable Long id){
    mvcRepository.deleteById(id);
    return "redirect:/";
  }

}

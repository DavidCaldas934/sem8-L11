package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.lang.String;

@Controller
@RequestMapping(path="/")
public class MainController {

    @Autowired 
  private CursoRepository Repository;

  @GetMapping(path="/")
  public @ResponseBody String home(){
    return "DC934 - David Caldas";
  }

    @GetMapping(path="/codigo")
  public @ResponseBody String codigo(){
    return "DC934";
  }

    @GetMapping(path="/nombre-completo")
  public @ResponseBody String nombre(){
    return "David - Caldas";
  }

  @GetMapping(path="/api/curso/listar")
  public @ResponseBody Iterable<Curso> listar(){
    return Repository.findAll();
  }

  @PostMapping(path="/api/curso/nuevo") 
  public @ResponseBody String addNewCurso (@RequestParam String nombre
      , @RequestParam Integer creditos) {

    Curso n = new Curso();
    n.setNombre(nombre);
    n.setCreditos(creditos);
    Repository.save(n);
    return "Curso guardado";
  }

  @DeleteMapping(path="/api/curso/eliminar")
  public @ResponseBody String eliminar(@RequestParam Integer id) {
    Curso n = new Curso();
    n.setId(id);
    Repository.delete(n);
    return "Curso eliminado";    
  }
  
}

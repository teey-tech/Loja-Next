package com.dev.backendloja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backendloja.entity.Categoria;
import com.dev.backendloja.service.CategoriaService;

@RestController
@RequestMapping("api/categoria/")
public class CategoriaController {

  @Autowired
  private CategoriaService service;

  @GetMapping("/")
  public List<Categoria> buscarTodos() {
    return service.buscarTodos();
  }

  @PostMapping("/")
  public Categoria inserir(@RequestBody Categoria categoria) {
    return service.inserir(categoria);
  }

  @PutMapping("/")
  public Categoria alterar(@RequestBody Categoria categoria) {
    return service.alterar(categoria);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
    service.deletar(id);
    return ResponseEntity.ok().build();
  }
}

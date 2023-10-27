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

import com.dev.backendloja.entity.Estado;
import com.dev.backendloja.service.EstadoService;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

  @Autowired
  private EstadoService service;

  @GetMapping("/")
  public List<Estado> consultar() {
    return service.buscarTodos();
  }

  @PostMapping("/")
  public Estado inserir(@RequestBody Estado estado) {
    return service.inserir(estado);
  }

  @PutMapping("/")
  public Estado alterar(@RequestBody Estado estado) {
    return service.alterar(estado);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
    service.excluir(id);
    return ResponseEntity.ok().build();
  }
}

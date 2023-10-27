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

import com.dev.backendloja.entity.Marca;
import com.dev.backendloja.service.MarcaService;

@RestController
@RequestMapping("api/marca/")
public class MarcaController {

  @Autowired
  private MarcaService service;

  @GetMapping("/")
  public List<Marca> buscarTodos() {
    return service.buscarTodos();
  }

  @PostMapping("/")
  public Marca inserir(@RequestBody Marca marca) {
    return service.inserir(marca);
  }

  @PutMapping("/")
  public Marca atualizar(@RequestBody Marca marca) {
    return service.atualizar(marca);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
    service.deletar(id);
    return ResponseEntity.ok().build();
  }
}

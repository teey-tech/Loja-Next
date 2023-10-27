package com.dev.backendloja.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dev.backendloja.entity.Estado;
import com.dev.backendloja.repository.EstadoRepository;

@Service
public class EstadoService {

  @Autowired
  private EstadoRepository repository;

  public List<Estado> buscarTodos() {
    return repository.findAll();
  }

  public Estado inserir(Estado estado) {
    estado.setDataCriacao(new Date());

    Estado estadoSalvo = repository.saveAndFlush(estado);
    return estadoSalvo;
  }

  public Estado alterar(Estado estado) {
    estado.setDataAtualizacao(new Date());
    return repository.saveAndFlush(estado);
  }

  public void excluir(Long id) {
    Optional<Estado> estadoEncontrado = repository.findById(id);
    repository.delete(estadoEncontrado.get());
  }
}

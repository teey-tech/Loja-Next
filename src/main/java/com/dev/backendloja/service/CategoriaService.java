package com.dev.backendloja.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backendloja.entity.Categoria;
import com.dev.backendloja.repository.CategoriaRepository;

@Service
public class CategoriaService {

  @Autowired
  private CategoriaRepository repository;

  public List<Categoria> buscarTodos() {
    return repository.findAll();
  }

  public Categoria inserir(Categoria categoria) {
    categoria.setDataCriacao(new Date());
    return repository.saveAndFlush(categoria);
  }

  public Categoria alterar(Categoria categoria) {
    categoria.setDataAtualizacao(new Date());
    return repository.saveAndFlush(categoria);
  }

  public void deletar(Long id) {
    Optional<Categoria> categoriaEncontrada = repository.findById(id);
    repository.delete(categoriaEncontrada.get());
  }
}

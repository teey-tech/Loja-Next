package com.dev.backendloja.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backendloja.entity.Marca;
import com.dev.backendloja.repository.MarcaRepository;

@Service
public class MarcaService {

  @Autowired
  private MarcaRepository repository;

  public List<Marca> buscarTodos() {
    return repository.findAll();
  }

  public Marca inserir(Marca marca) {
    marca.setDataCriacao(new Date());
    return repository.saveAndFlush(marca);
  }

  public Marca alterar(Marca marca) {
    marca.setDataCriacao(marca.getDataCriacao());
    marca.setDataAtualizacao(new Date());
    return repository.saveAndFlush(marca);
  }

  public void deletar(long id) {
    Optional<Marca> marcaEncontrada = repository.findById(id);
    repository.delete(marcaEncontrada.get());
  }
}

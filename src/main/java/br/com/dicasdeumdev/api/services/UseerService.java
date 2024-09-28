package br.com.dicasdeumdev.api.services;

import br.com.dicasdeumdev.api.domain.Useer;

import java.util.List;

public interface UseerService {

    Useer findById(Integer id);

    List<Useer> findAll();
}

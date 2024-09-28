package br.com.dicasdeumdev.api.services;

import br.com.dicasdeumdev.api.domain.Useer;
import br.com.dicasdeumdev.api.domain.dto.UseerDTO;

import java.util.List;

public interface UseerService {

    Useer findById(Integer id);

    List<Useer> findAll();

    Useer create(UseerDTO obj);

    Useer update(UseerDTO obj);
}

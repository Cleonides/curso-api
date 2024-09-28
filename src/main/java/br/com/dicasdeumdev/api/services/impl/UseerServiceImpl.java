package br.com.dicasdeumdev.api.services.impl;

import br.com.dicasdeumdev.api.domain.Useer;
import br.com.dicasdeumdev.api.repositories.UseerRepository;
import br.com.dicasdeumdev.api.services.UseerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UseerServiceImpl implements UseerService {

    @Autowired
    private UseerRepository repository;

    @Override
    public Useer findById(Integer id) {
        Optional<Useer> obj = repository.findById(id);
        return obj.orElse(null);
    }
}

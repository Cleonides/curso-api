package br.com.dicasdeumdev.api.services.impl;

import br.com.dicasdeumdev.api.domain.Useer;
import br.com.dicasdeumdev.api.domain.dto.UseerDTO;
import br.com.dicasdeumdev.api.repositories.UseerRepository;
import br.com.dicasdeumdev.api.services.UseerService;
import br.com.dicasdeumdev.api.services.exceptions.DataIntegrationViolationException;
import br.com.dicasdeumdev.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UseerServiceImpl implements UseerService {

    @Autowired
    private UseerRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Useer findById(Integer id) {
        Optional<Useer> obj = repository.findById(id);
        return obj.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado"));
    }

    @Override
    public List<Useer> findAll() {
        return repository.findAll() ;
    }

    @Override
    public Useer create(UseerDTO obj) {
        findByEmail(obj);
        return repository.save(modelMapper.map(obj, Useer.class));
    }

    @Override
    public Useer update(UseerDTO obj) {
        findByEmail(obj);
        return repository.save(modelMapper.map(obj, Useer.class))  ;
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private void findByEmail(UseerDTO obj){
        Optional<Useer> user = repository.findByEmail(obj.getEmail());
        if(user.isPresent() && !user.get().getId().equals(obj.getId())){
            throw new DataIntegrationViolationException("E-mail já cadastrado no sistema");
        }
    }


}

package br.com.dicasdeumdev.api.resources;

import br.com.dicasdeumdev.api.domain.dto.UseerDTO;
import br.com.dicasdeumdev.api.repositories.UseerRepository;
import br.com.dicasdeumdev.api.services.UseerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value =  "/user")
public class UseerResource {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UseerService service;
    @Autowired
    private UseerRepository useerRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UseerDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(modelMapper.map(service.findById(id), UseerDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UseerDTO>> findAll() {
        return ResponseEntity.ok().body(modelMapper.map(service.findAll(), List.class));
    }

    @PostMapping
    public ResponseEntity<UseerDTO> create(@RequestBody UseerDTO obj){
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequestUri().path("/{id}").buildAndExpand(service.create(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UseerDTO> update(@PathVariable Integer id, @RequestBody UseerDTO obj){
        obj.setId(id);
        return ResponseEntity.ok().body(modelMapper.map(service.update(obj), UseerDTO.class));

    }

}

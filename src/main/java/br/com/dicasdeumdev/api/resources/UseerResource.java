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

    public static final String ID = "/{id}";
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UseerService service;
    @Autowired
    private UseerRepository useerRepository;

    @GetMapping(value = ID)
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
                fromCurrentRequestUri().path(ID).buildAndExpand(service.create(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = ID)
    public ResponseEntity<UseerDTO> update(@PathVariable Integer id, @RequestBody UseerDTO obj){
        obj.setId(id);
        return ResponseEntity.ok().body(modelMapper.map(service.update(obj), UseerDTO.class));

    }

    @DeleteMapping(value = ID)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        findById(id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}

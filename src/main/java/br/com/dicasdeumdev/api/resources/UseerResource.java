package br.com.dicasdeumdev.api.resources;

import br.com.dicasdeumdev.api.domain.dto.UseerDTO;
import br.com.dicasdeumdev.api.services.UseerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value =  "/user")
public class UseerResource {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UseerService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UseerDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(modelMapper.map(service.findById(id), UseerDTO.class));
    }
}

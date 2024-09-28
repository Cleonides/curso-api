package br.com.dicasdeumdev.api.resources;

import br.com.dicasdeumdev.api.domain.Useer;
import br.com.dicasdeumdev.api.services.UseerService;
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
    private UseerService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Useer> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}

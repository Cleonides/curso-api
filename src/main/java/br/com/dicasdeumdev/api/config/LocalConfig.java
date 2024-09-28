package br.com.dicasdeumdev.api.config;

import br.com.dicasdeumdev.api.domain.Useer;
import br.com.dicasdeumdev.api.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void startDB(){
        Useer u1 = new Useer(null, "Valdir", "valdir@gmail.com" , "123");
        Useer u2 = new Useer(null, "Luiz", "Luiz@gmail.com" , "123");

        repository.saveAll(List.of(u1, u2));
    }
}

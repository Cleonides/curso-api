package br.com.dicasdeumdev.api.repositories;

import br.com.dicasdeumdev.api.domain.Useer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UseerRepository extends JpaRepository<Useer, Integer> {

    Optional<Useer> findByEmail(String email);
}

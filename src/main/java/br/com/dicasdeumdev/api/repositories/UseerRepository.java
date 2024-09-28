package br.com.dicasdeumdev.api.repositories;

import br.com.dicasdeumdev.api.domain.Useer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UseerRepository extends JpaRepository<Useer, Integer> {
}

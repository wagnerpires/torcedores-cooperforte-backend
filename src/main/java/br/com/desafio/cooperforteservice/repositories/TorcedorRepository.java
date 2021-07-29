package br.com.desafio.cooperforteservice.repositories;

import br.com.desafio.cooperforteservice.dtos.TorcedorDTO;
import br.com.desafio.cooperforteservice.entities.Torcedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TorcedorRepository extends JpaRepository<Torcedor, Integer> {
    Optional<Torcedor> findById(Long id);

    List<Torcedor> findAllByExcluidoFalse();


}

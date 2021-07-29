package br.com.desafio.cooperforteservice.repositories;

import br.com.desafio.cooperforteservice.entities.Logs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Logs, Long> {
}

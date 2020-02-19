package br.com.sas.simulados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sas.simulados.model.Gabarito;

@Repository
public interface GabaritoRepository extends JpaRepository<Gabarito, Long> {

}

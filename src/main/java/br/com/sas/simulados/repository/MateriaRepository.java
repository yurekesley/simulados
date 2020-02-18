package br.com.sas.simulados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sas.simulados.model.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {

}

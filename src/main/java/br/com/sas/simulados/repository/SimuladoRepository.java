package br.com.sas.simulados.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sas.simulados.model.Simulado;

@Repository
public interface SimuladoRepository extends JpaRepository<Simulado, Long>{

    @Query(value = "SELECT c FROM Simulado c JOIN FETCH c.provas")   
	List<Simulado> findAll();
}

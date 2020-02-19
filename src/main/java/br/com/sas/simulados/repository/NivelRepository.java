/**
 * 
 */
package br.com.sas.simulados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sas.simulados.model.Nivel;

/**
 * @author yure.placido
 * @Data 19 de fev de 2020
 */
@Repository
public interface NivelRepository extends JpaRepository<Nivel, Long> {

}

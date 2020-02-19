/**
 * 
 */
package br.com.sas.simulados.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import br.com.sas.simulados.model.IBaseModel;

/**
 * @author yure.placido
 * @Data 17 de fev de 2020
 */
public interface IReadService<T extends IBaseModel, ID extends Serializable> {

	T findById(@PathVariable(value = "id") ID id);

	List<T> findAll();
}

/**
 * 
 */
package br.com.sas.simulados.service.readonly;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sas.simulados.model.IBaseModel;
import lombok.Getter;

/**
 * @author yure.placido
 * @Data 17 de fev de 2020
 */
public abstract class ReadService<T extends IBaseModel, ID extends Serializable> implements IReadService<T, ID> {

	@Getter
	private JpaRepository<IBaseModel, ID> repository;

	
	@Autowired
	@SuppressWarnings("unchecked")
	public void setRepository(JpaRepository<T, ID> repositorio) {
		this.repository = (JpaRepository<IBaseModel, ID>) repositorio;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public T findById(ID id) {
		T entity = (T) getRepository().findById(id).get();
		afterFindById(entity);
		return entity;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		List<T> entities = (List<T>) getRepository().findAll();
		afterFindAll(entities);
		return entities;
	}

	public void afterFindById(T entidade) {
	}

	public void afterFindAll(List<T> entidades) {
	}
}

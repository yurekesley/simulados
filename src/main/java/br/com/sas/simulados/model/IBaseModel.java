/**
 * 
 */
package br.com.sas.simulados.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author yure.placido
 * @Data 17 de fev de 2020
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public interface IBaseModel {
}

/**
 * 
 */
package br.com.sas.simulados.util;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.bridge.MessageUtil;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.util.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.sas.simulados.exception.TypeError;
import br.com.sas.simulados.json.JsonResult;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yure.placido
 * @Data 11 de fev de 2020
 */

@Slf4j
public class ResourceBundleUtil {

	private static ResourceBundleMessageSource resourceBundleMessageSource;

	public static void setResourceBundleMessageSource(ResourceBundleMessageSource resourceBundleMessageSource) {
		Assert.notNull(resourceBundleMessageSource, "msg.traducao.instancia.bundle");
		ResourceBundleUtil.resourceBundleMessageSource = resourceBundleMessageSource;
	}

	public static String montarMensagem(String mensagem, Locale locale, Object[] parametros) {
		try {
			if (locale == null) {
				HttpServletRequest requisicaoCorrente = RestUtil.getCurrentRequest();
				locale = Locale.getDefault();
				if (requisicaoCorrente != null && requisicaoCorrente.getLocale() != null) {
					locale = requisicaoCorrente.getLocale();
				}
			}

			return resourceBundleMessageSource.getMessage(mensagem, parametros, locale);
		} catch (NoSuchMessageException ex) {
			return mensagem;
		}
	}

	public static String montarMensagem(String message, Object... params) {
		return montarMensagem(message, null, params);
	}

	public static String montarRespostaMensagemJson(TypeError tipoError, String mensagem, Object... parametros) {
		ObjectMapper mapper = new ObjectMapper();
		String mensagemBundle = montarMensagem(mensagem, null, parametros);
		try {
			return mapper.writeValueAsString(
					JsonResult.builder().code(tipoError.getCode()).mensagem(mensagemBundle).build());
		} catch (Throwable e) {
			log.error(e.getMessage());
		}
		return mensagemBundle;
	}

}

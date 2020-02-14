/**
 * 
 */
package br.com.sas.simulados.dbunit;

import java.util.Calendar;
import java.util.Date;

import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.stereotype.Component;

import br.com.triadworks.dbunit.resolver.DefaultDbUnitDataSetResolver;

/**
 * @author yure.placido
 * @Data 14 de fev de 2020
 */

@Component
public class CustomDbUnitDataSetResolver extends DefaultDbUnitDataSetResolver {
	@Override
	protected ReplacementDataSet configureReplacement(FlatXmlDataSet dataSet) {
		ReplacementDataSet replacement = super.configureReplacement(dataSet);

		replacement.addReplacementObject("[CURRENT_DATE]", new Date(System.currentTimeMillis()));

		Calendar calendar = Calendar.getInstance();
		for (int i = 1; i < 31; i++) {
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			replacement.addReplacementObject("-" + i + "D[CURRENT_DATE]", calendar.getTime());
		}

		calendar = Calendar.getInstance();
		for (int i = 1; i < 31; i++) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			replacement.addReplacementObject("+" + i + "D[CURRENT_DATE]", calendar.getTime());
		}

		return replacement;
	}
}

package it.prova.gestionemotore.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionemotore.model.Motore;

//nel nome della classe vi è Articolo in quanto è una classe specifica
public class UtilityArticoloForm {

	public static Motore createMotoreFromParams(String codiceInputParam, String cilindrataInputParam,
			String potenzaInputStringParam, String coppiaInputStringParam, String dataProduzioneStringParam) {

		Motore result = new Motore(codiceInputParam);

		if (NumberUtils.isCreatable(cilindrataInputParam)) {
			result.setCilindrata(Integer.parseInt(cilindrataInputParam));
		}

		if (NumberUtils.isCreatable(potenzaInputStringParam)) {
			result.setPotenza(Integer.parseInt(potenzaInputStringParam));
		}

		if (NumberUtils.isCreatable(coppiaInputStringParam)) {
			result.setCoppia(Integer.parseInt(coppiaInputStringParam));
		}

		result.setDataProduzione(parseDateProduzioneFromString(dataProduzioneStringParam));

		return result;
	}

	public static boolean validateMotoreBean(Motore motoreToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(motoreToBeValidated.getCodice())
				|| motoreToBeValidated.getCilindrata() < 1
				|| motoreToBeValidated.getPotenza() < 1
				|| motoreToBeValidated.getCoppia() < 1 
				|| motoreToBeValidated.getDataProduzione() == null) {
			return false;
		}
		return true;
	}

	public static Date parseDateProduzioneFromString(String dataArrivoStringParam) {
		if (StringUtils.isBlank(dataArrivoStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataArrivoStringParam);
		} catch (ParseException e) {
			return null;
		}
	}

	public static Long parseLongArrivoFromString(String longArrivoStringParam) {
		if (StringUtils.isBlank(longArrivoStringParam))
			return null;

		try {
			return Long.parseLong(longArrivoStringParam);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Integer parseIntArrivoFromString(String intArrivoStringParam) {
		if (StringUtils.isBlank(intArrivoStringParam))
			return null;

		try {
			return Integer.parseInt(intArrivoStringParam);
		} catch (Exception e) {
			return null;
		}
	}
	
}

package it.prova.gestionemotore.service;

import it.prova.gestionemotore.dao.MotoreDAO;
import it.prova.gestionemotore.dao.MotoreDAOImpl;

public class MyServiceFactory {

	// implementiamo il singleton in modo da evitare
	// proliferazione di riferimenti
	private static MotoreService MOTORE_SERVICE_INSTANCE = null;
	private static MotoreDAO MOTOREDAO_INSTANCE = null;

	public static MotoreService getMotoreServiceInstance() {
		if (MOTORE_SERVICE_INSTANCE == null)
			MOTORE_SERVICE_INSTANCE = new MotoreServiceImpl();

		if (MOTOREDAO_INSTANCE == null)
			MOTOREDAO_INSTANCE = new MotoreDAOImpl();

		MOTORE_SERVICE_INSTANCE.setMotoreDao(MOTOREDAO_INSTANCE);

		return MOTORE_SERVICE_INSTANCE;
	}

}

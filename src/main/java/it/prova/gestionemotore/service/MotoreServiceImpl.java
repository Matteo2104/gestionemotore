package it.prova.gestionemotore.service;

import java.util.List;

import javax.persistence.EntityManager;
import it.prova.gestionemotore.dao.MotoreDAO;
import it.prova.gestionemotore.model.Motore;
import it.prova.gestionemotore.web.listener.LocalEntityManagerFactoryListener;

public class MotoreServiceImpl implements MotoreService {

	private MotoreDAO motoreDao;

	public void setMotoreDao(MotoreDAO motoreDao) {
		this.motoreDao = motoreDao;
	}

	@Override
	public List<Motore> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			motoreDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return motoreDao.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Motore caricaSingoloElemento(Long idInput) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			motoreDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return motoreDao.findOne(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Motore input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			motoreDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			motoreDao.update(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void inserisciNuovo(Motore input) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			motoreDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			motoreDao.insert(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	@Override
	public void rimuovi(Motore input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			motoreDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			motoreDao.delete(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<Motore> findByExample(Motore input) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

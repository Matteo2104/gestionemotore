package it.prova.gestionemotore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionemotore.model.Motore;

public class MotoreDAOImpl implements MotoreDAO {

	private EntityManager entityManager;

	@Override
	public List<Motore> list() throws Exception {
		return entityManager.createQuery("from Motore", Motore.class).getResultList();
	}

	@Override
	public Motore findOne(Long id) throws Exception {
		return entityManager.find(Motore.class, id);
	}

	@Override
	public void update(Motore input) throws Exception {
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Motore input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Motore input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}

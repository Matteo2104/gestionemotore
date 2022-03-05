package it.prova.gestionemotore.service;

import java.util.List;

import it.prova.gestionemotore.dao.MotoreDAO;
import it.prova.gestionemotore.model.Motore;

public interface MotoreService {

	// questo mi serve per injection
	public void setMotoreDao(MotoreDAO motoreDao);

	public List<Motore> listAll() throws Exception;

	public Motore caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(Motore input) throws Exception;

	public void inserisciNuovo(Motore input) throws Exception;

	public void rimuovi(Motore input) throws Exception;

	List<Motore> trovaDaEsempio(Motore input) throws Exception;

}

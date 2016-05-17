package it.uniroma3.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UtenteMain {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("medici-unit");
		EntityManager em = emf.createEntityManager();

		Utente u = new Utente("Rosaria", "Rossi", "rosaria.rossi", "pass", "paziente");
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(u);
		tx.commit();

		em.close();
		emf.close();
	}
}

package it.uniroma3.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MedicoMain {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("medici-unit");
		EntityManager em = emf.createEntityManager();

		Medico medico = new Medico();
		medico.setName("Mario");
		medico.setCognome("Rossi");
		medico.setSpecializzazione("Chirurgo");

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(medico);
		tx.commit();

		em.close();
		emf.close();
	}
}

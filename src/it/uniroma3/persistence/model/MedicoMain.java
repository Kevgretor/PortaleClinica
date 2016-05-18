package it.uniroma3.persistence.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MedicoMain {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		EntityManager em = emf.createEntityManager();

		Medico medico = new Medico();
		medico.setNome("Mario");
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

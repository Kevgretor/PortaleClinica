package it.uniroma3.persistence.model;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EsameMain {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		EntityManager em = emf.createEntityManager();

		//Creazione Medico
		Medico medico = new Medico();
		medico.setNome("Ciccio");
		medico.setCognome("Cicciarelli");
		medico.setSpecializzazione("Dietologo");
		
		//Creazione Paziente
		Utente u = new Utente("Obesa", "McDowell", "obesa2", "pass", "paziente");
		
		
		Esame es = new Esame(u, medico, new Date());
		

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(u);
		em.persist(medico);
		em.persist(es);
		tx.commit();

		em.close();
		emf.close();
	}
}

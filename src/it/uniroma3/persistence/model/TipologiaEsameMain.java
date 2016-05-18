package it.uniroma3.persistence.model;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TipologiaEsameMain {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		EntityManager em = emf.createEntityManager();

		//Creazione Medico
		TipologiaEsame te = new TipologiaEsame("Esame Prostata", "Un minuzioso controllo della prostata", 19.99f, "nessuno", "risultato");
		

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(te);
		tx.commit();

		em.close();
		emf.close();
	}
}

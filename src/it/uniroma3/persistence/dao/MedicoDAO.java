package it.uniroma3.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import it.uniroma3.persistence.model.Medico;

public class MedicoDAO {
	
	public MedicoDAO() {
		
	}
	
	public void insertMedico(Medico medico)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(medico);
		tx.commit();
		
		em.close();
		emf.close();
	}

}

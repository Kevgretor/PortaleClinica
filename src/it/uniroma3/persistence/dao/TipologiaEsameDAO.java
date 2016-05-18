package it.uniroma3.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.uniroma3.persistence.model.TipologiaEsame;

public class TipologiaEsameDAO {
	
	TipologiaEsameDAO() {
		
	}
	
	public void insertTipologiaEsame(TipologiaEsame te)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(te);
		tx.commit();

		em.close();
		emf.close();
	}
	
	public TipologiaEsame getTipologiaEsame(Long id)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		EntityManager em = emf.createEntityManager();
		
		em.createNativeQuery("SELECT te from TipologiaEsame WHERE )

		em.close();
		emf.close();
	}

}

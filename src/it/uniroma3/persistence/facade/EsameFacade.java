package it.uniroma3.persistence.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.persistence.model.Esame;
import it.uniroma3.persistence.model.Medico;
import it.uniroma3.persistence.model.Utente;

@Stateless
public class EsameFacade {
	
	@PersistenceContext(unitName = "clinica-unit")
	private EntityManager em;
	
	public Esame createEsame(Utente utente, Medico medico, Date dataEsame)
	{
		Esame e = new Esame(utente, medico, dataEsame);
		em.persist(e);
		return e;
	}
	
	public Esame getEsame(Long id)
	{
		Esame e = em.find(Esame.class, id);
		return e;
	}
	
	@SuppressWarnings("unchecked")
	public List<Esame> getEsamiByUtente(Long id)
	{
		Query q = em.createNativeQuery("SELECT * FROM esame WHERE id_paziente=:id", Esame.class);
		q.setParameter("id", id);
		List<Esame> esame = q.getResultList();
		return esame;
	}
	
	public List<Esame> getAllEsami() 
	{
		CriteriaQuery<Esame> cq = em.getCriteriaBuilder().createQuery(Esame.class);
		cq.select(cq.from(Esame.class));
		List<Esame> esame = em.createQuery(cq).getResultList();
		return esame;
	}
	
	public void updateEsame(Esame e)
	{
		em.merge(e);
	}
	
	public void deleteEsame(Esame e)
	{
		em.remove(e);
	}
	
	public void deleteEsame(Long id)
	{
		Esame e = em.find(Esame.class, id);
		em.remove(e);
	}

}

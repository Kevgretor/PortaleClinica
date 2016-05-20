package it.uniroma3.persistence.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.persistence.model.Medico;
import it.uniroma3.persistence.model.Utente;

@Stateless
public class UtenteFacade {
	
	@PersistenceContext(unitName = "clinica-unit")
	private EntityManager em;
	
	public Utente createUtente(String nome, String cognome, String username, String password, String role)
	{
		Utente u = new Utente(nome, cognome, username, password, role);
		em.persist(u);
		return u;
	}
	
	public Utente getUtente(Long id)
	{
		Utente u = em.find(Utente.class, id);
		return u;
	}
	
	public List<Utente> getAllUtenti() 
	{
		CriteriaQuery<Utente> cq = em.getCriteriaBuilder().createQuery(Utente.class);
		cq.select(cq.from(Utente.class));
		List<Utente> u = em.createQuery(cq).getResultList();
		return u;
	}
	
	public void updateUtente(Utente u)
	{
		em.merge(u);
	}
	
	public void deleteUtente(Utente u)
	{
		em.remove(u);
	}
	
	public void deleteUtente(Long id)
	{
		Utente u = em.find(Utente.class, id);
		em.remove(u);
	}

}

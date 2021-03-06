package it.uniroma3.persistence.facade;

import it.uniroma3.persistence.model.Utente;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class UtenteFacade {

	@PersistenceContext(unitName = "clinica-unit")
	private EntityManager em;

	public UtenteFacade() { }
	
	public Utente createUtente(String nome, String cognome, String username,
			String password, String role) {
		Utente u = new Utente(nome, cognome, username, password, role);
		em.persist(u);
		return u;
	}

	public Utente getUtente(Long id) {
		Utente u = em.find(Utente.class, id);
		return u;
	}

	@SuppressWarnings("unchecked")
	public Utente getUtenteByUsername(String username) {
		Utente utente = null;
		Query q = em.createNativeQuery(
				"SELECT * FROM utente WHERE username=:username", Utente.class);
		q.setParameter("username", username);
		List<Utente> risultati = q.getResultList();
		if (!risultati.isEmpty())
			utente = (Utente) q.getResultList().get(0);
		return utente;
	}

	public List<Utente> getAllUtenti() {
		CriteriaQuery<Utente> cq = em.getCriteriaBuilder().createQuery(
				Utente.class);
		cq.select(cq.from(Utente.class));
		List<Utente> u = em.createQuery(cq).getResultList();
		return u;
	}

	@SuppressWarnings("unchecked")
	public List<Utente> getAllUtentiPazienti() {
		Query q = em.createNativeQuery("SELECT * FROM utente WHERE role=:role",
				Utente.class);
		q.setParameter("role", "paziente");
		List<Utente> risultati = q.getResultList();
		return risultati;
	}

	public void updateUtente(Utente u) {
		em.merge(u);
	}

	public void deleteUtente(Utente u) {
		em.remove(u);
	}

	public void deleteUtente(Long id) {
		Utente u = em.find(Utente.class, id);
		em.remove(u);
	}

}

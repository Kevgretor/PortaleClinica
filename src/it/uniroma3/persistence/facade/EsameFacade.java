package it.uniroma3.persistence.facade;

import it.uniroma3.persistence.model.Esame;
import it.uniroma3.persistence.model.Medico;
import it.uniroma3.persistence.model.TipologiaEsame;
import it.uniroma3.persistence.model.Utente;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class EsameFacade {

	@PersistenceContext(unitName = "clinica-unit")
	private EntityManager em;

	public Esame createEsame(Utente utente, Medico medico,
			TipologiaEsame tipologiaEsame, Date dataEsame) {
		Esame e = new Esame(utente, medico, tipologiaEsame, dataEsame);
		em.persist(e);
		return e;
	}

	public Esame getEsame(Long id) {
		Esame e = em.find(Esame.class, id);
		return e;
	}

	@SuppressWarnings("unchecked")
	public List<Esame> getEsamiByUtente(Long id) {
		Query q = em.createNativeQuery(
				"SELECT * FROM esame WHERE id_paziente=:id", Esame.class);
		q.setParameter("id", id);
		List<Esame> esame = q.getResultList();
		return esame;
	}

	;

	@SuppressWarnings("unchecked")
	public List<Esame> getEsamiByNomeAndCognomeMedico(String nome,
			String cognome) {
		Query q = em
				.createNativeQuery(
						"SELECT * FROM esame, medico WHERE medico.nome=:nome AND medico.cognome=:cognome",
						Esame.class);
		q.setParameter("nome", nome);
		q.setParameter("cognome", cognome);
		List<Esame> esame = q.getResultList();
		return esame;
	}

	public List<Esame> getEsamiByMedico(Long id) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Esame> cq = cb.createQuery(Esame.class);
		Root<Esame> esame = cq.from(Esame.class);
		cq.select(esame).where(cb.equal(esame.get("medico"), id));
		List<Esame> esami = em.createQuery(cq).getResultList();
		return esami;

	}

	public List<Esame> getAllEsami() {
		CriteriaQuery<Esame> cq = em.getCriteriaBuilder().createQuery(
				Esame.class);
		cq.select(cq.from(Esame.class));
		List<Esame> esame = em.createQuery(cq).getResultList();
		return esame;
	}

	public void updateEsame(Esame e) {
		em.merge(e);
	}

	public void deleteEsame(Esame e) {
		em.remove(e);
	}

	public void deleteEsame(Long id) {
		Esame e = em.find(Esame.class, id);
		em.remove(e);
	}

}

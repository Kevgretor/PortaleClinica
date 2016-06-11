package it.uniroma3.persistence.facade;

import it.uniroma3.persistence.model.RisultatoEsame;
import it.uniroma3.persistence.model.RisultatoEsameRiga;
import it.uniroma3.persistence.model.Utente;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class RisultatoEsameFacade {

	@PersistenceContext(unitName = "clinica-unit")
	private EntityManager em;

	public RisultatoEsameFacade() { }
	
	public RisultatoEsame createRisultatoEsame(List<RisultatoEsameRiga> risultatoEsameRiga) {
		RisultatoEsame re = new RisultatoEsame(risultatoEsameRiga);
		em.persist(re);
		return re;
	}
	
	public RisultatoEsame getRisultatoEsame(Long id)
	{
		RisultatoEsame re = em.find(RisultatoEsame.class, id);
		return re;
	}

	public void updateRisultatoEsame(RisultatoEsame re) {
		em.merge(re);
	}

	public void deleteRisultatoEsame(RisultatoEsame re) {
		em.remove(re);
	}

	public void deleteRisultatoEsame(Long id) {
		RisultatoEsame re = em.find(RisultatoEsame.class, id);
		em.remove(re);
	}

}

package it.uniroma3.persistence.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.persistence.model.TipologiaEsame;

@Stateless
public class TipologiaEsameFacade {
	
	@PersistenceContext(unitName = "clinica-unit")
	private EntityManager em;
	
	public TipologiaEsame createTipologiaEsame(String nome, String descrizione, float costo, String prerequisiti, String indicatoreRisultati)
	{
		TipologiaEsame m = new TipologiaEsame(nome, descrizione, costo, prerequisiti, indicatoreRisultati);
		em.persist(m);
		return m;
	}
	
	public TipologiaEsame getTipologiaEsame(Long id)
	{
		TipologiaEsame te = em.find(TipologiaEsame.class, id);
		return te;
	}
	
	public List<TipologiaEsame> getAllTipologiaEsame() 
	{
		CriteriaQuery<TipologiaEsame> cq = em.getCriteriaBuilder().createQuery(TipologiaEsame.class);
		cq.select(cq.from(TipologiaEsame.class));
		List<TipologiaEsame> te = em.createQuery(cq).getResultList();
		return te;
	}
	
	public void updateTipologiaEsame(TipologiaEsame te)
	{
		em.merge(te);
	}
	
	public void deleteTipologiaEsame(TipologiaEsame te)
	{
		em.remove(te);
	}
	
	public void deleteTipologiaEsame(Long id)
	{
		TipologiaEsame te = em.find(TipologiaEsame.class, id);
		em.remove(te);
	}

}

package it.uniroma3.persistence.facade;

import it.uniroma3.persistence.model.Medico;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class MedicoFacade {

	@PersistenceContext(unitName = "clinica-unit")
	private EntityManager em;

	public Medico createMedico(String nome, String cognome,
			String specializzazione) {
		Medico m = new Medico(nome, cognome, specializzazione);
		em.persist(m);
		return m;
	}

	public Medico getMedico(Long id) {
		Medico m = em.find(Medico.class, id);
		return m;
	}

	public List<Medico> getAllMedici() {
		CriteriaQuery<Medico> cq = em.getCriteriaBuilder().createQuery(
				Medico.class);
		cq.select(cq.from(Medico.class));
		List<Medico> medici = em.createQuery(cq).getResultList();
		return medici;
	}

	public void updateMedico(Medico medico) {
		em.merge(medico);
	}

	public void deleteMedico(Medico medico) {
		em.remove(medico);
	}

	public void deleteMedico(Long id) {
		Medico medico = em.find(Medico.class, id);
		em.remove(medico);
	}

}

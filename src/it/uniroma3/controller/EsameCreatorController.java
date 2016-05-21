package it.uniroma3.controller;

import it.uniroma3.persistence.facade.EsameFacade;
import it.uniroma3.persistence.facade.MedicoFacade;
import it.uniroma3.persistence.facade.TipologiaEsameFacade;
import it.uniroma3.persistence.facade.UtenteFacade;
import it.uniroma3.persistence.model.Medico;
import it.uniroma3.persistence.model.TipologiaEsame;
import it.uniroma3.persistence.model.Utente;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ManagedBean
@SessionScoped
public class EsameCreatorController {

	private List<Utente> utenti;
	private List<Medico> medici;
	private List<TipologiaEsame> tipologiaEsami;
	
	private Medico medico;
	private Utente utente;
	private TipologiaEsame tipologiaEsame;
	private Date dataEsame;
	
	private Long medico_id, utente_id, tipologiaEsame_id;
	
	@EJB
	private UtenteFacade utenteFacade;
	@EJB
	private MedicoFacade medicoFacade;
	@EJB
	private TipologiaEsameFacade tipologiaEsameFacade;
	@EJB
	private EsameFacade esameFacade;
	
	public String newEsame() {
		utenti = utenteFacade.getAllUtenti();
		medici = medicoFacade.getAllMedici();
		tipologiaEsami = tipologiaEsameFacade.getAllTipologiaEsame();
		return "newEsame";
	}
	
	public String createEsame() 
	{
		for (Utente u : utenti)
			if(u.getId()==utente_id)
				this.utente = u;
		for(Medico m : medici)
			if(m.getId()==medico_id)
				this.medico = m;
		for(TipologiaEsame te : tipologiaEsami)
			if(te.getId()==tipologiaEsame_id)
				this.tipologiaEsame = te;
		esameFacade.createEsame(utente, medico, tipologiaEsame, dataEsame);
		return "index";
	}
	
	public void getObjectReferences()
	{
		for (Medico m : medici)
			if(m.getId()==medico_id)
				this.medico = m;
		for (Utente u : utenti)
			if(u.getId()==utente_id)
				this.utente = u;
		for (TipologiaEsame te : tipologiaEsami)
			if(te.getId()==tipologiaEsame_id)
				this.tipologiaEsame = te;
	}

	public List<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}

	public List<Medico> getMedici() {
		return medici;
	}

	public void setMedici(List<Medico> medici) {
		this.medici = medici;
	}

	public List<TipologiaEsame> getTipologiaEsami() {
		return tipologiaEsami;
	}

	public void setTipologiaEsami(List<TipologiaEsame> tipologiaEsami) {
		this.tipologiaEsami = tipologiaEsami;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}

	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}

	public Date getDataEsame() {
		return dataEsame;
	}

	public void setDataEsame(Date dataEsame) {
		this.dataEsame = dataEsame;
	}

	public Long getMedico_id() {
		return medico_id;
	}

	public void setMedico_id(Long medico_id) {
		this.medico_id = medico_id;
	}

	public Long getUtente_id() {
		return utente_id;
	}

	public void setUtente_id(Long utente_id) {
		this.utente_id = utente_id;
	}

	public Long getTipologiaEsame_id() {
		return tipologiaEsame_id;
	}

	public void setTipologiaEsame_id(Long tipologiaEsame_id) {
		this.tipologiaEsame_id = tipologiaEsame_id;
	}
	
	
	
}
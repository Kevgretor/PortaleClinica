package it.uniroma3.controller;

import it.uniroma3.persistence.facade.EsameFacade;
import it.uniroma3.persistence.model.Esame;
import it.uniroma3.persistence.model.Medico;
import it.uniroma3.persistence.model.TipologiaEsame;
import it.uniroma3.persistence.model.Utente;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class EsameController {

	@ManagedProperty(value = "#{param.id}")
	private Long id;
	private Date dataEsame;
	private Medico medico;
	private Utente utente;
	private Esame esame;
	private TipologiaEsame tipologiaEsame;
	private List<Esame> esami;

	@EJB
	private EsameFacade esameFacade;

	public String createEsame() {
		this.esame = esameFacade.createEsame(utente, medico, tipologiaEsame,
				dataEsame);
		return "esame";
	}

	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}

	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}

	public String findEsame() {
		this.esame = esameFacade.getEsame(id);
		return "esame_dettagli";
	}

	public String findEsameDiUtente(Long id) {
		this.esami = esameFacade.getEsamiByUtente(id);
		return "esami_utente";
	}

	public String listEsami() {
		this.esami = esameFacade.getAllEsami();
		return "esami";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataEsame() {
		return dataEsame;
	}

	public void setDataEsame(Date dataEsame) {
		this.dataEsame = dataEsame;
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

	public Esame getEsame() {
		return esame;
	}

	public void setEsame(Esame esame) {
		this.esame = esame;
	}

	public List<Esame> getEsami() {
		return esami;
	}

	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}
}
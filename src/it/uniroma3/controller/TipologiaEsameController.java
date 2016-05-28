package it.uniroma3.controller;

import it.uniroma3.persistence.facade.TipologiaEsameFacade;
import it.uniroma3.persistence.model.TipologiaEsame;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TipologiaEsameController {

	@ManagedProperty(value = "#{id}")
	private Long id;
	private String nome;
	private String descrizione;
	private float costo;
	private String requisiti;
	private String indicatoreRisultati;
	private TipologiaEsame te;
	private List<TipologiaEsame> tesami;

	private String messaggio;

	@EJB
	private TipologiaEsameFacade tipologiaEsameFacade;

	public String createTipologiaEsame() {
		if (nome.equals("") || descrizione.equals("") || requisiti.equals("")
				|| indicatoreRisultati.equals("") || costo == 0.f) {
			messaggio = "Tutti i campi sono obbligatori.";
			return "";
		}
		this.te = tipologiaEsameFacade.createTipologiaEsame(nome, descrizione,
				costo, requisiti, indicatoreRisultati);
		nome = "";
		descrizione = "";
		costo = 0f;
		requisiti = "";
		indicatoreRisultati = "";

		messaggio = "";
		return "tipologiaEsameSuccess";
	}

	public String findTipologiaEsame(Long id) {
		this.te = tipologiaEsameFacade.getTipologiaEsame(id);
		return "/public/tipologiaEsameDettagli";
	}

	public String listTipologiaEsame() {
		this.tesami = tipologiaEsameFacade.getAllTipologiaEsame();
		return "/public/tipologiaEsameList";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public String getRequisiti() {
		return requisiti;
	}

	public void setRequisiti(String requisiti) {
		this.requisiti = requisiti;
	}

	public String getIndicatoreRisultati() {
		return indicatoreRisultati;
	}

	public void setIndicatoreRisultati(String indicatoreRisultati) {
		this.indicatoreRisultati = indicatoreRisultati;
	}

	public TipologiaEsame getTe() {
		return te;
	}

	public void setTe(TipologiaEsame te) {
		this.te = te;
	}

	public TipologiaEsameFacade getTipologiaEsameFacade() {
		return tipologiaEsameFacade;
	}

	public void setTipologiaEsameFacade(
			TipologiaEsameFacade tipologiaEsameFacade) {
		this.tipologiaEsameFacade = tipologiaEsameFacade;
	}

	public List<TipologiaEsame> getTesami() {
		return tesami;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
}
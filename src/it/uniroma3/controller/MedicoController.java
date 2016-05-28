package it.uniroma3.controller;

import it.uniroma3.persistence.facade.MedicoFacade;
import it.uniroma3.persistence.model.Medico;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class MedicoController {

	@ManagedProperty(value = "#{param.id}")
	private Long id;
	private String nome;
	private String cognome;
	private String specializzazione;
	private Medico medico;
	private List<Medico> medici;

	@EJB
	private MedicoFacade medicoFacade;

	public String createMedico() {
		this.medico = medicoFacade
				.createMedico(nome, cognome, specializzazione);
		return "medico";
	}

	public String findMedico() {
		this.medico = medicoFacade.getMedico(id);
		return "medico";
	}

	public String findMedico(Long Id) {
		this.medico = medicoFacade.getMedico(id);
		return "medico";
	}

	public String listMedici() {
		this.medici = medicoFacade.getAllMedici();
		return "/amministrazione/ricercaEsameDaMedico";
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getSpecializzazione() {
		return specializzazione;
	}

	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Medico> getMedici() {
		return medici;
	}
}
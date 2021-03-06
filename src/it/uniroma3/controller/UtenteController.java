package it.uniroma3.controller;

import it.uniroma3.persistence.facade.UtenteFacade;
import it.uniroma3.persistence.model.Utente;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class UtenteController {

	@ManagedProperty(value = "#{param.id}")
	private Long id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private String role;
	private Utente utente;
	private List<Utente> utenti;

	@EJB
	private UtenteFacade utenteFacade;

	public String createPaziente() {
		this.utente = utenteFacade.createUtente(nome, cognome, username,
				password, "paziente");
		return "utente_creato";
	}

	public String createAmministratore() {
		this.utente = utenteFacade.createUtente(nome, cognome, username,
				password, "amministratore");
		return "amministratore_creato";
	}

	public String findUtente() {
		this.utente = utenteFacade.getUtente(id);
		return "utente_dettagli";
	}

	public String findUtente(Long id) {
		this.utente = utenteFacade.getUtente(id);
		return "utente_dettagli";
	}

	public String findUtente(String username) {
		this.utente = utenteFacade.getUtenteByUsername(username);
		return "utente_dettagli";
	}

	public String listUtenti() {
		this.utenti = utenteFacade.getAllUtenti();
		return "utente_list";
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

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public List<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}

	public String getUsername() {
		return username;
	}

	public String getRole() {
		return role;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
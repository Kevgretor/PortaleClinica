package it.uniroma3.controller;

import java.util.List;

import it.uniroma3.persistence.facade.UtenteFacade;
import it.uniroma3.persistence.model.Utente;

import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class Login {
	
	private String username;
	private String password;
	private String role;
	private Utente utente;
	private String messaggio;
	
	
	@EJB
	UtenteFacade utenteFacade;
	
	public String login() 
	{		
		Utente utente = utenteFacade.getUtenteByUsername(username);
		String psw = password;
		password = null;
		if(utente==null)
		{
			messaggio = "*username errato";
			return "login";
		}
		if(utente.getPassword().equals(psw))
		{
			this.utente = utente;
			return "index";
		}
		messaggio = "*password errata";
		return "login";
	}
	public void logout() 
	{
		utente = null;
	}

	public boolean isLoggedIn() 
	{
		return utente != null;
	}

	Utente getCurrentUser()
	{
		return utente;
	}
	/*public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}*/
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMessaggio() {
		return messaggio;
	}
	
	

}
package it.uniroma3.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utente_id")
	@SequenceGenerator(name = "utente_id", sequenceName = "utente_id", allocationSize = 1)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cognome;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String role;

	public Utente() {
	}

	public Utente(String nome, String cognome, String username,
			String password, String role) {
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	// Getters & Setters

	public Long getId() {
		return id;
	}

	public String getNome() {
		return this.nome;
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return this.role;
	}

	public boolean equals(Object obj) {
		Utente utente = (Utente) obj;
		return this.getId().equals(utente.getId());
	}

	public int hashCode() {
		return this.getId().hashCode();
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Utente");
		sb.append("{id=").append(id);
		sb.append(", name='").append(nome);
		sb.append(", cognome=").append(cognome);
		sb.append(", username='").append(username);
		sb.append(", password='").append(password);
		sb.append(", role='").append(role);
		sb.append("}\n");
		return sb.toString();
	}

}
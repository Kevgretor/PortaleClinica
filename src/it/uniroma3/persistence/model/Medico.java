package it.uniroma3.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;

	@Entity
	@NamedQuery(name = "findAllMedici", query = "SELECT m FROM Medico m")
	public class Medico {
        
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medico_id")
	@SequenceGenerator(name="medico_id", sequenceName="medico_id", allocationSize=1)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cognome;
	
	@Column(length = 2000, nullable = false)
	private String specializzazione;
	
	public Medico() {
    }

	public Medico(String nome, String cognome, String specializzazione) {
        this.nome = nome;
        this.cognome = cognome;
        this.specializzazione = specializzazione;
}

    //          Getters & Setters        
    
   public Long getId() {
        return id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSpecializzazione() {
        return this.specializzazione;
    }

    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
    	this.cognome = cognome;
    }

    public boolean equals(Object obj) {
        Medico medico = (Medico)obj;
        return this.getId().equals(medico.getId());
    }

    public int hashCode() {
         return this.getId().hashCode();
    }
/*
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Medico"); 
        sb.append("{id=").append(id); 
        sb.append(", name='").append(nome); 
        sb.append(", cognome=").append(cognome); 
        sb.append(", specializzazione='").append(specializzazione); 
        sb.append("}\n");
        return sb.toString();
    }*/
	
}
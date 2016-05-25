package it.uniroma3.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "tipologia_di_esame")
public class TipologiaEsame {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipologia_esame_id")
	@SequenceGenerator(name = "tipologia_esame_id", sequenceName = "tipologia_esame_id", allocationSize = 1)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String descrizione;

	@Column(nullable = false)
	private float costo;

	@Column(nullable = false)
	private String prerequisiti;

	@Column(name = "indicatore_risultati", nullable = false)
	private String indicatoreRisultati;

	public TipologiaEsame() {
	}

	public TipologiaEsame(String nome, String descrizione, float costo,
			String prerequisiti, String indicatoreRisultati) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.costo = costo;
		this.prerequisiti = prerequisiti;
		this.indicatoreRisultati = indicatoreRisultati;
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

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public float getCosto() {
		return this.costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public String getPrerequisiti() {
		return this.prerequisiti;
	}

	public void setPrerequisiti(String prerequisiti) {
		this.prerequisiti = prerequisiti;
	}

	public String getIndicatoreRisultati() {
		return this.indicatoreRisultati;
	}

	public void setIndicatoreRisultati(String indicatoreRisultati) {
		this.indicatoreRisultati = indicatoreRisultati;
	}

	public boolean equals(Object obj) {
		TipologiaEsame te = (TipologiaEsame) obj;
		return this.getId().equals(te.getId());
	}

	public int hashCode() {
		return this.getId().hashCode();
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("TipologiaEsame");
		sb.append("{id=").append(id);
		sb.append(", name='").append(nome);
		sb.append(", descrizione='").append(descrizione);
		sb.append(", costo='").append(costo);
		sb.append(", prerequisiti='").append(prerequisiti);
		sb.append(", indicatore risultati='").append(indicatoreRisultati);
		sb.append("}\n");
		return sb.toString();
	}

}
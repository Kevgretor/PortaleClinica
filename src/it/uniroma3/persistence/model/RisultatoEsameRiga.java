package it.uniroma3.persistence.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "risultato_esame_riga")
public class RisultatoEsameRiga {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "risultato_esame_riga_id")
	@SequenceGenerator(name = "risultato_esame_riga_id", sequenceName = "risultato_esame_riga_id", allocationSize = 1)
	private Long id;
	
	@Column(name = "valore", nullable = false)
	private String valore;
	
	@ManyToOne
	@JoinColumn(name = "risultato_esame", nullable = false)
	private RisultatoEsame risultatoEsame;
	
	public RisultatoEsameRiga() {
	}

	public RisultatoEsameRiga(String valore) {
		this.valore = valore;
	}

	// Getters & Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	public RisultatoEsame getRisultatoEsame() {
		return risultatoEsame;
	}

	public void setRisultatoEsame(RisultatoEsame risultatoEsame) {
		this.risultatoEsame = risultatoEsame;
	}

	public int hashCode() {
		return this.getId().hashCode();
	}
	
	public boolean equals(Object obj) {
		RisultatoEsameRiga rer = (RisultatoEsameRiga) obj;
		return this.getId().equals(rer.getId());
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("RisultatoEsameRiga");
		sb.append("{id=").append(id);
		sb.append(", Valore='").append(valore);
		sb.append("}\n");
		return sb.toString();
	}

}
package it.uniroma3.persistence.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "risultato_esame")
public class RisultatoEsame {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "risultato_esame_id")
	@SequenceGenerator(name = "risultato_esame_id", sequenceName = "risultato_esame_id", allocationSize = 1)
	private Long id;
	
	@OneToMany(mappedBy = "risultato_esame")
	@JoinColumn(name = "risultato_esame_riga", nullable = false)
	private List<RisultatoEsameRiga> risultatoEsameRighe;

	public RisultatoEsame() {
	}

	public RisultatoEsame(List<RisultatoEsameRiga> risultatoEsameRiga) {
		this.risultatoEsameRighe = risultatoEsameRiga;
	}

	// Getters & Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public List<RisultatoEsameRiga> getRisultatoEsameRighe() {
		return risultatoEsameRighe;
	}

	public void setRisultatoEsameRighe(List<RisultatoEsameRiga> risultatoEsameRighe) {
		this.risultatoEsameRighe = risultatoEsameRighe;
	}

	public int hashCode() {
		return this.getId().hashCode();
	}
	
	public boolean equals(Object obj) {
		RisultatoEsame rer = (RisultatoEsame) obj;
		return this.getId().equals(rer.getId());
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("RisultatoEsame");
		sb.append("{id=").append(id);
		sb.append(", Risultati='").append(risultatoEsameRighe.toString());
		sb.append("}\n");
		return sb.toString();
	}

}
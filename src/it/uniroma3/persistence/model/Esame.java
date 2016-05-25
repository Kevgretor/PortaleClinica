package it.uniroma3.persistence.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

	@Entity
	public class Esame {
        
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "esame_id")
	@SequenceGenerator(name="esame_id", sequenceName="esame_id", allocationSize=1)
	private Long id;

	@Column(name="data_esame", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataEsame;

	@Column(name="data_prenotazione", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPrenotazione;
	
	@ManyToOne
	@JoinColumn(name = "id_medico", nullable = false)
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name = "id_tipologiaesame", nullable = false)
	private TipologiaEsame tipologiaEsame;
	
	@ManyToOne
	@JoinColumn(name = "id_paziente", nullable=false)
	private Utente utente;
	
	public Esame() {
    }

	public Esame(Utente utente, Medico medico, TipologiaEsame tipologiaEsame, Date dataEsame) {
		this.dataEsame = dataEsame;
		this.dataPrenotazione = new Date();
        this.utente = utente;
        this.medico = medico;
        this.tipologiaEsame = tipologiaEsame;
}

    //          Getters & Setters        
    
   public Long getId() {
        return id;
    }
   
   public Utente getUtente() {
	   return this.utente;
   }
   
   public void setUtente(Utente utente) {
	   this.utente = utente;
   }
   
   public Medico getMedico() {
	   return this.medico;
   }
   
   public void setMedico(Medico medico) {
	   this.medico = medico;
   }
   
   public Date getDataEsame() {
	   return this.dataEsame;
   }
   
   public void setDataEsame(Date dataEsame) {
	   this.dataEsame = dataEsame;
   }
   
   public Date getDataPrenotazione() {
	   return this.dataPrenotazione;
   }
   
   public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
	   this.tipologiaEsame = tipologiaEsame;
   }
   
   public TipologiaEsame getTipologiaEsame() {
	   return this.tipologiaEsame;
   }

    public boolean equals(Object obj) {
        Esame esame = (Esame)obj;
        return this.getId().equals(esame.getId());
    }

    public int hashCode() {
         return this.getId().hashCode();
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Esame"); 
        sb.append("{id=").append(id);
        sb.append("{paziente=").append(utente.toString());
        sb.append("{medico=").append(medico.toString());
        sb.append("{data esame=").append(dataEsame.toString());
        sb.append("}\n");
        return sb.toString();
    }
    
    @PreUpdate
    protected void onUpdate() {
    	this.dataPrenotazione = new Date();
    }
	
}
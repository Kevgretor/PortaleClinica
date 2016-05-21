package it.uniroma3.controller;

import it.uniroma3.persistence.facade.EsameFacade;
import it.uniroma3.persistence.facade.MedicoFacade;
import it.uniroma3.persistence.facade.TipologiaEsameFacade;
import it.uniroma3.persistence.facade.UtenteFacade;
import it.uniroma3.persistence.model.Esame;
import it.uniroma3.persistence.model.Medico;
import it.uniroma3.persistence.model.TipologiaEsame;
import it.uniroma3.persistence.model.Utente;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@ManagedBean
public class EsameController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private Date dataEsame;
	private Medico medico;
	private Utente utente;
	private Esame esame;
	private TipologiaEsame tipologiaEsame;
	private List<Esame> esami;
	
	@EJB
	private EsameFacade esameFacade;
	
	public String createEsame() {
		this.esame = esameFacade.createEsame(utente, medico, tipologiaEsame, dataEsame);
		return "esame"; 
	}
	
	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}

	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}


	public String findEsame()
	{
		this.esame = esameFacade.getEsame(id);
		return "esame_dettagli";
	}
	
	public String findEsameDiUtente(Long id)
	{
		this.esami = esameFacade.getEsamiByUtente(id);
		return "esami_utente";
	}
	
	public String listEsami()
	{
		this.esami = esameFacade.getAllEsami();
		return "esami";
	}
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}

	public Date getDataEsame() {
		return dataEsame;
	}

	public void setDataEsame(Date dataEsame) {
		this.dataEsame = dataEsame;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Esame getEsame() {
		return esame;
	}

	public void setEsame(Esame esame) {
		this.esame = esame;
	}

	public List<Esame> getEsami() {
		return esami;
	}

	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}
	
	
	
	/*
	public String listProducts() {
		this.products = productFacade.getAllProducts();
		return "products"; 
	}

	public String findProduct() {
		this.product = productFacade.getProduct(id);
		return "product";
	}
	
	public String findProduct(Long id) {
		this.product = productFacade.getProduct(id);
		return "product";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	*/
}



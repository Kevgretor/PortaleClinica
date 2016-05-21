package it.uniroma3.controller;

import it.uniroma3.persistence.facade.TipologiaEsameFacade;
import it.uniroma3.persistence.model.TipologiaEsame;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class TipologiaEsameController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String nome;
	private String descrizione;
	private float costo;
	private String requisiti;
	private String indicatoreRisultati;
	private TipologiaEsame te;
	private List<TipologiaEsame> tesami;
	
	@EJB
	private TipologiaEsameFacade tipologiaEsameFacade;
	
	public String createTipologiaEsame() {
		this.te = tipologiaEsameFacade.createTipologiaEsame(nome, descrizione, costo, requisiti, indicatoreRisultati);
		return "esame"; 
	}
	
	public String findTipologiaEsame()
	{
		this.te = tipologiaEsameFacade.getTipologiaEsame(id);
		return "tipologiaEsame_dettagli";
	}


	public String listTipologiaEsame()
	{
		this.tesami = tipologiaEsameFacade.getAllTipologiaEsame();
		return "tipologiaEsame_list";
	}
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public String getRequisiti() {
		return requisiti;
	}

	public void setRequisiti(String requisiti) {
		this.requisiti = requisiti;
	}

	public String getIndicatoreRisultati() {
		return indicatoreRisultati;
	}

	public void setIndicatoreRisultati(String indicatoreRisultati) {
		this.indicatoreRisultati = indicatoreRisultati;
	}

	public TipologiaEsame getTe() {
		return te;
	}

	public void setTe(TipologiaEsame te) {
		this.te = te;
	}

	public TipologiaEsameFacade getTipologiaEsameFacade() {
		return tipologiaEsameFacade;
	}

	public void setTipologiaEsameFacade(TipologiaEsameFacade tipologiaEsameFacade) {
		this.tipologiaEsameFacade = tipologiaEsameFacade;
	}

	public List<TipologiaEsame> getTesami() {
		return tesami;
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


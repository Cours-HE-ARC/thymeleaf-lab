package ch.hearc.spring.thymeleaf.model;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Produit {

	@NotNull
    @Size(min=2, max=30)
	private String nom;
	
	@NotNull
	@DecimalMax("1000.0") @DecimalMin("0.0") 
	private BigDecimal prix;
	
	public Produit(String nom, BigDecimal prix) {
		super();
		this.nom = nom;
		this.prix = prix;
	}
	
	public Produit() {
		// TODO Auto-generated constructor stub
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}
	
	public BigDecimal getPrix() {
		return prix;
	}

	@Override
	public String toString() {
		return "Produit [nom=" + nom + ", prix=" + prix + "]";
	}
	
	
}

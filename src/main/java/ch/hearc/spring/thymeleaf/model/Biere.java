package ch.hearc.spring.thymeleaf.model;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import ch.hearc.spring.thymeleaf.model.Etudiant;


public class Biere {
	
	private String nom;
	private BigDecimal prix;
	private String fabricant;
	private Integer stock;
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public BigDecimal getPrix() {
		return prix;
	}
	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}
	public String getFabricant() {
		return fabricant;
	}
	public void setFabricant(String fabricant) {
		this.fabricant = fabricant;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Biere(Integer id,String nom, BigDecimal prix, String fabricant, Integer stock) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.fabricant = fabricant;
		this.stock = stock;
	}
	public Biere() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}

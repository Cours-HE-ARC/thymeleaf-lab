package ch.hearc.spring.thymeleaf.data.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import ch.hearc.spring.thymeleaf.data.ProduitDAO;
import ch.hearc.spring.thymeleaf.model.Produit;

@Component
public class InMemoryProduitDAO implements ProduitDAO{

	private static List<Produit> DATASOURCE = new ArrayList<>();
	
	
	static{
		DATASOURCE.add(new Produit("produit 1",new BigDecimal("12.50")));
		DATASOURCE.add(new Produit("produit 2",new BigDecimal(18)));
		
	}


	@Override
	public List<Produit> findAll() {
		// TODO Auto-generated method stub
		return DATASOURCE;
	}


	@Override
	public void save(@Valid Produit produit) {
		DATASOURCE.add(produit);
		
	}


	
	
	
}

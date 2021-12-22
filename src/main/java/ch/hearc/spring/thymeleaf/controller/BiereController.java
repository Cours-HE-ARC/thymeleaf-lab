package ch.hearc.spring.thymeleaf.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ch.hearc.spring.thymeleaf.data.BieresDAO;
import ch.hearc.spring.thymeleaf.data.ProduitDAO;
import ch.hearc.spring.thymeleaf.model.Biere;
import ch.hearc.spring.thymeleaf.model.Etudiant;
import ch.hearc.spring.thymeleaf.model.Produit;

@Controller
public class BiereController {

	@Autowired
	BieresDAO bdao;
	
	@GetMapping(value = "/bieres")
	public String findAllProduits(Map<String, Object> model){
		System.out.println("/bieres GET");
		model.put("bieres", bdao.getAllBieres());
		model.put("biere", new Biere());
		
		
		return "bieres";
	}
	
	@PostMapping("/bieres")
	public String saveBiere(@Valid @ModelAttribute Biere biere, BindingResult errors, Model model) {
		
		
		if (!errors.hasErrors()) {
            bdao.save(biere);
        }
        return ((errors.hasErrors()) ? "biere_detail" : "redirect:bieres");
	}
	
	@GetMapping(value = "/saisie_biere")
	public String saisieBiere(Map<String, Object> model){
		
		
		model.put("biere", new Biere());
		
		
		return "biere_detail";
	}
	
	@GetMapping(value = "/delete_biere/{id}")
	public String deleteBiere(@PathVariable Integer id,Map<String, Object> model){
		
			System.out.println(id);
            bdao.deleteBiere(id);
            model.put("bieres", bdao.getAllBieres());
        
        return "redirect:/bieres";
	}
	
	
	
	
}

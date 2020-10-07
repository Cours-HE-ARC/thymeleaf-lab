package ch.hearc.spring.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.hearc.spring.thymeleaf.data.EtudiantsDAO;
import ch.hearc.spring.thymeleaf.model.Etudiant;

@Controller
public class AccueilController {

		@Autowired
		EtudiantsDAO dao;
		
		@Value("${accueil.message:test}")
		private String message;
		
		@Value("${accueil1.message:[default]}")
		private String messageParDefaut;

		@GetMapping("/")
		public String accueil(Map<String, Object> model) {
			model.put("page", "Accueil");
			return "accueil";
		}
		
		@GetMapping("/basic")
		public String basic(Map<String, Object> model) {
			model.put("message", this.message);
			model.put("page", "Concepts de bases");
			
			model.put("message", this.message);
			model.put("messageParDefaut", this.messageParDefaut);
			model.put("page", "Concepts de bases");
			
			
			model.put("etudiants", dao.getAllEtudianst());
			return "basic";
		}
		
		@GetMapping("/form")
		public String form(Map<String, Object> model) {
			model.put("etudiant", new Etudiant());
			model.put("page", "Formulaire");
			return "formulaire";
		}
		
		@GetMapping("/aleaTudiant")
		public String aleaTudiant(Map<String, Object> model) {
			model.put("etudiant", new Etudiant());
			model.put("page", "Formulaire");
			return "aleaTudiant";
		}
		
	
	
	
		
		@PostMapping("/etudiant")
		public String saveEtudiant(@Valid @ModelAttribute Etudiant etudiant, BindingResult errors, Model model) {
			
			
			if (!errors.hasErrors()) {
	            dao.save(etudiant);
	            
	            
	        }
	        return ((errors.hasErrors()) ? "etudiant" : "redirect:basic");
		}
}



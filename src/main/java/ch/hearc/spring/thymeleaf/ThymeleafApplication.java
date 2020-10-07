package ch.hearc.spring.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ch.hearc.spring.thymeleaf.data.EtudiantsDAO;
import ch.hearc.spring.thymeleaf.model.Role;
import ch.hearc.spring.thymeleaf.model.RoleRepository;
import ch.hearc.spring.thymeleaf.model.Utilisateur;
import ch.hearc.spring.thymeleaf.model.UtilisateurRepository;

@SpringBootApplication
public class ThymeleafApplication {

	@Autowired
	RoleRepository roleRepo;
	@Autowired
	UtilisateurRepository utilisateurRepo;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	  return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ThymeleafApplication.class, args);
	}
	
	@Bean
	public EtudiantsDAO etudiantsDAO () {
		return new EtudiantsDAO();
	}
	
	@PostConstruct
	public void initData() {
	  //Création du role admin
	  Role role = new Role();
	  role.setNom("ROLE_ADMIN"); 
	  roleRepo.save(role);

	  //creation de l'utilisateur
	  Utilisateur u = new Utilisateur();
	  u.setNomUtilisateur("admin7");
	  u.setMotDePasse(bCryptPasswordEncoder.encode("password"));
	  
	  //Ajout des rôles à l'utilisateur
	  Set<Role> roles = new HashSet<>();
	  roles.add(role);
	  u.setRoles(roles);
	  utilisateurRepo.save(u);
	}
}

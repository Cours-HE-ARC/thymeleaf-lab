package ch.hearc.spring.thymeleaf.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToMany(mappedBy = "roles")
    private Set<Utilisateur> users;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Utilisateur> getUsers() {
		return users;
	}

	public void setUsers(Set<Utilisateur> users) {
		this.users = users;
	}

    //Getter et setter
    //Constructeur par défaut
}
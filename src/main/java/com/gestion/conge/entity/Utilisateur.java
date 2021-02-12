package com.gestion.conge.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.gestion.conge.entity.GestionJson.NiveauBase;

 
@Entity
@Table(name = "utilisateur")
@SequenceGenerator(name = "seqUtilisateur", sequenceName = "seq_utilisateur", initialValue = 10, allocationSize = 1)
public class Utilisateur{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUtilisateur")
	private Integer id;
	
	@Column(name = "mail", length = 200)
	@JsonView(GestionJson.NiveauBase.class)
	private String mail;
	@Column(name = "password", length = 200)
	private String password;
	@Column(name = "nom", length = 100)
	@JsonView(GestionJson.NiveauBase.class)
	protected String nom;
	@Column(name = "prenom", length = 100)
	@JsonView(GestionJson.NiveauBase.class)
	protected String prenom;
	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	@JsonView(GestionJson.NiveauBase.class)
	private Role role;
	
	@Enumerated(EnumType.STRING)
	@OneToMany(mappedBy = "utilisateur")
	@JsonView(GestionJson.EmployeAvecConge.class)
	private List<Conge> conge;
	
	@ManyToOne
	@JoinColumn(name = "id_s")
	protected ServiceU service;
	@JsonView(GestionJson.EmployeAvecConge.class)
	protected Integer id_manager;

	public Utilisateur() {
	}

	public Utilisateur(String nom, String prenom,String mail, String password,  Role role,ServiceU service, Integer id_manager) {
		this.nom = nom;
		this.prenom = prenom;		
		this.mail = mail;
		this.password = password;
		this.role = role;
		this.service = service;
		this.id_manager = id_manager;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Conge> getConge() {
		return conge;
	}

	public void setConge(List<Conge> conge) {
		this.conge = conge;
	}

	public ServiceU getService() {
		return service;
	}

	public void setService(ServiceU service) {
		this.service = service;
	}

	public Integer getId_manager() {
		return id_manager;
	}

	public void setId_manager(Integer id_manager) {
		this.id_manager = id_manager;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	
}

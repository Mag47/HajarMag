package com.gestion.conge.entity;

import java.util.List;

import javax.persistence.*;
@Entity
@Table(name = "service")
@SequenceGenerator(name = "seqService", sequenceName = "seq_service", initialValue = 10, allocationSize = 1)

public class ServiceU {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqService")
	private Integer id;
	private String libelle;
	@OneToMany(mappedBy = "service")
	private List<Utilisateur> utilisateur;
	
	public ServiceU() {
	}

	public ServiceU(String libelle) {
		this.libelle = libelle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Utilisateur> getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(List<Utilisateur> utilisateur) {
		this.utilisateur = utilisateur;
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
		ServiceU other = (ServiceU) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

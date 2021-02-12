package com.gestion.conge.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@SequenceGenerator(name = "seqConge")
public class Conge {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqConge")
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@JsonView(GestionJson.NiveauBase.class)
	private TypeC typec;
	@Column(name = "Date_demande",columnDefinition = "DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonView(GestionJson.NiveauBase.class)
	private LocalDate demande=LocalDate.now();
	
	@Column(name = "Date_debut",columnDefinition = "DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonView(GestionJson.NiveauBase.class)
	private LocalDate debut;
	
	@Column(name = "Date_fin",columnDefinition = "DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonView(GestionJson.NiveauBase.class)
	private LocalDate fin;
	
	@Column(name = "Nbr_jours")
	@JsonView(GestionJson.NiveauBase.class)
	private double nbr_jours;
	@JsonView(GestionJson.NiveauBase.class)
	private String motif;
	@JsonView(GestionJson.NiveauBase.class)
	private String statut;
	@JsonView(GestionJson.NiveauBase.class)
	private String commentaire;
	@ManyToOne
	private Utilisateur utilisateur;
	
	
	
	public Conge() {
	}


	public Conge(TypeC typec, LocalDate debut, LocalDate fin, String motif) {
		this.typec = typec;
		this.debut = debut;
		this.fin = fin;
		this.motif = motif;
	}


	public Conge(TypeC typec, LocalDate debut, LocalDate fin, String motif, Utilisateur utilisateur) {
		this.typec = typec;
		this.debut = debut;
		this.fin = fin;
		this.motif = motif;
		this.utilisateur = utilisateur;
	}
	
	
	public Conge(LocalDate date) {
		
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public TypeC getTypec() {
		return typec;
	}
	public void setTypec(TypeC typec) {
		this.typec = typec;
	}
	public LocalDate getDemande() {
		return demande;
	}
	public void setDemande(LocalDate demande) {
		this.demande = demande;
	}
	public LocalDate getDebut() {
		return debut;
	}
	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}
	public LocalDate getFin() {
		return fin;
	}
	public void setFin(LocalDate fin) {
		this.fin = fin;
	}
	public double getNbr_jours() {
		return nbr_jours;
	}
	public void setNbr_jours(double nbr_jours) {
		this.nbr_jours = nbr_jours;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
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
		Conge other = (Conge) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	
	
}

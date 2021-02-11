package com.gestion.conge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.conge.entity.Role;
import com.gestion.conge.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	public Optional<Utilisateur> findByMail(String mail);
	public List<Utilisateur> findAllByRole(Role role);
	
}

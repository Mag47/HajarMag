package com.gestion.conge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestion.conge.entity.Role;
import com.gestion.conge.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	public Optional<Utilisateur> findByMail(String mail);
	public List<Utilisateur> findAllByRole(Role role);
	
	@Query("select u from Utilisateur u where u.id_manager=:param")
	public List<Utilisateur> findAllId_manager(@Param("param") Integer param);
}

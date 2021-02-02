package com.gestion.conge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestion.conge.entity.Conge;
import com.gestion.conge.entity.Service;


public interface CongeRepository extends JpaRepository<Conge, Integer>{
	@Query("select p from Conge p where p.utilisateur.service=:param")
	public List<Conge> findAllConge(@Param("param") Service service);
	

}

package com.gestion.conge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.conge.entity.Service;

public interface ServiceRepository extends JpaRepository<Service, Integer>{

}

package com.gestion.conge.service;

import java.lang.annotation.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gestion.conge.entity.Role;
import com.gestion.conge.entity.ServiceU;
import com.gestion.conge.entity.Utilisateur;
import com.gestion.conge.repository.ServiceRepository;
import com.gestion.conge.repository.UtilisateurRepository;

@Service
public class InitUserInDataBase implements CommandLineRunner {
	@Autowired
	private PasswordEncoder passwordEncorder;
	@Autowired
	private UtilisateurRepository userRepo;
	@Autowired
	private ServiceRepository serviceRepo;

	@Override
	public void run(String... args) throws Exception {

		ServiceU s1 = new ServiceU("Developpement");
		serviceRepo.save(s1);
		Utilisateur u1 = new Utilisateur("Mag", "Magali", "magali@gmail.com", passwordEncorder.encode("magali"), Role.ROLE_MANAGER, s1, 10);
		userRepo.save(u1);
		Utilisateur u = new Utilisateur("Ram", "Hajar", "hajar@gmail.com", passwordEncorder.encode("hajar"), Role.ROLE_ADMINISTRATEUR, s1, 11);
		userRepo.save(u);
		Utilisateur u2 = new Utilisateur("coco", "mami", "mami@gmail.com", passwordEncorder.encode("mami"), Role.ROLE_EMPLOYE, s1, 10);
		
	}
}

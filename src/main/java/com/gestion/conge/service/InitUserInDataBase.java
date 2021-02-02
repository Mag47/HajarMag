package com.gestion.conge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gestion.conge.entity.Role;
import com.gestion.conge.entity.Utilisateur;
import com.gestion.conge.repository.UtilisateurRepository;

@Service
public class InitUserInDataBase implements CommandLineRunner {
	@Autowired
	private PasswordEncoder passwordEncorder;
	@Autowired
	private UtilisateurRepository userRepo;

	@Override
	public void run(String... args) throws Exception {
		Utilisateur u = new Utilisateur();
		u.setMail("hajar@gmail.com");
		u.setRole(Role.ROLE_ADMINISTRATEUR);
		u.setPassword(passwordEncorder.encode("hajar"));
		userRepo.save(u);
	}
}

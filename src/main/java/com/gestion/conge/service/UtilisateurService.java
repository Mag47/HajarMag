package com.gestion.conge.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gestion.conge.entity.UserDetailsWithUtilisateur;
import com.gestion.conge.entity.Utilisateur;
import com.gestion.conge.repository.UtilisateurRepository;

@Service
public class UtilisateurService implements org.springframework.security.core.userdetails.UserDetailsService  {

	
	@Autowired
	private UtilisateurRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Utilisateur> opt = userRepo.findByMail(username);
		if (opt.isPresent()) {
			return new UserDetailsWithUtilisateur(opt.get());
		}
		throw new UsernameNotFoundException("mail inconnu");
	}
	

}

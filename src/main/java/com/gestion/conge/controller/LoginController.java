package com.gestion.conge.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestion.conge.entity.Utilisateur;

@Controller
@RequestMapping("/basic")
public class LoginController {

	@GetMapping("/bye")
	public String bye() {
		return "bye";
	}

	@GetMapping("/accueil")
	public String home() {
		//SecurityContext ctx = SecurityContextHolder.getContext();				
		//Utilisateur emp = (Utilisateur) ctx.getAuthentication().getPrincipal();
		return "accueil";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}

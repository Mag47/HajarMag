package com.gestion.conge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/bye")
	public String bye() {
		return "bye";
	}

	@GetMapping("/accueil")
	public String home() {
		return "accueil";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}

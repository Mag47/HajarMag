package com.gestion.conge.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gestion.conge.entity.Utilisateur;
import com.gestion.conge.repository.UtilisateurRepository;
import com.gestion.conge.service.UtilisateurService;

@Controller
@RequestMapping("/basic/employe")
public class EmployeController {

	@Autowired
	private UtilisateurService userService;
	
	@Autowired
	private UtilisateurRepository userRepo;

	@GetMapping({ "", "/" })
	public ModelAndView list() {
		return new ModelAndView("employe/list", "employes", userRepo.findAll());
	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name = "id") Integer numero) {
		userRepo.deleteById(numero);
		return new ModelAndView("redirect:/basic/employe");
	}

	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam(name = "id") Integer id) {
		Optional<Utilisateur> opt = userRepo.findById(id);
		if (opt.isPresent()) return goForm(userRepo.findById(id).get()); 
		else return null;
	}

	@GetMapping("/add")
	public ModelAndView add() {
		return goForm(new Utilisateur());
	}

	private ModelAndView goForm(Utilisateur optional) {
		ModelAndView modelAndView = new ModelAndView("employe/edit");
		modelAndView.addObject("employe", optional);
		return modelAndView;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid @ModelAttribute("employe") Utilisateur employe, BindingResult br) {

		
		if (br.hasErrors()) {
			return goForm(employe);
		}
		userRepo.save(employe);
		return new ModelAndView("redirect:/basic/employe");
	}
}

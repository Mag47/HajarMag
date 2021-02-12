package com.gestion.conge.controller;

import java.time.Duration;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gestion.conge.entity.Conge;
import com.gestion.conge.entity.Utilisateur;
import com.gestion.conge.repository.CongeRepository;
import com.gestion.conge.repository.UtilisateurRepository;
import com.gestion.conge.service.UserDetailsWithUtilisateur;

@Controller
@RequestMapping("/basic/nouvelleDemande")
public class CongeController {

	@Autowired
	private CongeRepository congeRepo;
	
	@Autowired
	private UtilisateurRepository userRepo;
	
	@GetMapping("list" )
	public String list(Model model) {
		List<Conge> conges = congeRepo.findAll();
		model.addAttribute("conges", conges);
		
		return "conge/list";
	}
	@GetMapping("/add")
	public ModelAndView add() {
		return goForm(new Conge());
	}
	
	private ModelAndView goForm(Conge optional) {
		ModelAndView modelAndView = new ModelAndView("conge");
		modelAndView.addObject("conge", optional);
		return modelAndView;
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid @ModelAttribute("conge") Conge conge,  BindingResult br,Authentication auto) {
		
		Utilisateur emp =((UserDetailsWithUtilisateur) auto.getPrincipal()).getUtilisateur(); 
		//Duration duration = Duration.between(conge.getDebut(), conge.getFin());
		//long nb_sec= duration.getSeconds();
		//Integer nb_jour = Math.toIntExact(nb_sec/86400);
		//conge.setNbr_jours(nb_jour);
		conge.setUtilisateur(emp);
		if (br.hasErrors()) {
			return goForm(conge);
		}
		congeRepo.save(conge);
		return new ModelAndView("redirect:/basic/accueil");
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name = "id") Integer numero) {
		congeRepo.deleteById(numero);
		return new ModelAndView("redirect:/basic/nouvelleDemande/list");
	}
}

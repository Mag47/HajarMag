package com.gestion.conge.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

import com.gestion.conge.entity.Conge;
import com.gestion.conge.repository.CongeRepository;

@Controller
@RequestMapping("/nouvelleDemande")
public class CongeController {

	@Autowired
	private CongeRepository congeRepo;
	
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
	public ModelAndView save(@Valid @ModelAttribute("conge") Conge conge, BindingResult br) {

		
		if (br.hasErrors()) {
			return goForm(conge);
		}
		congeRepo.save(conge);
		return new ModelAndView("redirect:/accueil");
	}
}

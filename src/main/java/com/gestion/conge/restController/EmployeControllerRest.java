package com.gestion.conge.restController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.conge.entity.Role;
import com.gestion.conge.entity.Utilisateur;
import com.gestion.conge.exception.UserInvalidException;
import com.gestion.conge.exception.UserNotFoundException;
import com.gestion.conge.repository.UtilisateurRepository;


@RestController
@RequestMapping("/api/employes")
@CrossOrigin(origins="*")
public class EmployeControllerRest {
	@Autowired
	private UtilisateurRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping({ "", "/" })
	public List<Utilisateur> getUsers(){
		return userRepository.findAllByRole(Role.ROLE_EMPLOYE);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Void> ajoutUser(@Valid @RequestBody Utilisateur user, BindingResult br) {
		if (br.hasErrors()) {
			throw new UserInvalidException();
		}
		user.setRole(Role.ROLE_EMPLOYE);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Optional<Utilisateur> user = userRepository.findById(id);
		if(user.get()==null){
			throw new UserNotFoundException();
		}
		userRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@PutMapping("/{id}")
	public Utilisateur update(@Valid @RequestBody Utilisateur p, BindingResult br, @PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			throw new UserInvalidException();
		}
		Optional<Utilisateur> user = userRepository.findById(id);
		if (user.get() == null) {
			throw new UserNotFoundException();
		}
		user.get().setPrenom(p.getPrenom());
		user.get().setNom(p.getNom());
		user.get().setService(p.getService());
		user.get().setId_manager(p.getId_manager());
		user.get().setRole(p.getRole());
		userRepository.save(user.get());
		return user.get();
	}
}

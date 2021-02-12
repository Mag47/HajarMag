package com.gestion.conge.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gestion.conge.entity.Utilisateur;

public class UserDetailsWithUtilisateur implements UserDetails {

	private Utilisateur utilisateur;

	public UserDetailsWithUtilisateur(Utilisateur utilisateur) {
		super();
		this.utilisateur = utilisateur;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(utilisateur.getRole().toString()));
	}

	@Override
	public String getPassword() {
		return utilisateur.getPassword();
	}

	@Override
	public String getUsername() {
		return utilisateur.getMail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

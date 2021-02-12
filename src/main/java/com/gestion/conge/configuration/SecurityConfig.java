package com.gestion.conge.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gestion.conge.service.UtilisateurService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UtilisateurService userDetailsService;
	@Configuration
	@Order(1)
	class ImplementationSecurity extends WebSecurityConfigurerAdapter{


		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off

			http.authorizeRequests()
			.antMatchers("/", "/css/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/basic/login")
			.defaultSuccessUrl("/basic/accueil")
			.failureUrl("/basic/login?error")
			.permitAll()
			.and()
			.logout()
			.logoutUrl("/basic/logout")
			.logoutSuccessUrl("/basic/bye")
			.permitAll();
			// @formatter:on

		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {

			auth.userDetailsService(userDetailsService);
		}
	}
	@Configuration
	@Order(2) 
	public class RestControllerSecurityConfig extends WebSecurityConfigurerAdapter {
		@Autowired
		private UtilisateurService  userDetailsService;

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			//@// @formatter:off		
			//activation des restcontroller
			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests().antMatchers(HttpMethod.OPTIONS).anonymous()
			.and()
			.csrf().disable().authorizeRequests()
			.antMatchers("/api/**").authenticated()
			.and().httpBasic();
			// @formatter:on
		}
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService);
		}
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

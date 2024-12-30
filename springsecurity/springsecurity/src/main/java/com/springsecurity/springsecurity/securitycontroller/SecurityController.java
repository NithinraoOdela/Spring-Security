package com.springsecurity.springsecurity.securitycontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.springsecurity.securitydto.MyUserdto;
import com.springsecurity.springsecurity.securityservice.UserService;

@RestController
@RequestMapping("security")
public class SecurityController {

	@Autowired
	public UserService userService;

	
	@GetMapping("sayhello")
	public ResponseEntity<String> sayHello() {
		return ResponseEntity.ok("Hello");
	}

	@PostMapping("register")
	public ResponseEntity<String> createUser(@RequestBody MyUserdto userDao) {
		return ResponseEntity.ok(userService.createUser(userDao));
	}

	@PostMapping("login")
	public ResponseEntity<String> loginUser(@RequestBody MyUserdto userDao) {
		return ResponseEntity.ok(userService.loginUser(userDao));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("getallusers")
	public ResponseEntity<List<MyUserdto>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

//Created project,  Adding username and password in application.prop
//Adding securityfilterchain for csrf
//Taking username and password from database and configure authoniticationprovider with httpbasic
//Encoding the password
//Adding the jwt 
//Generating token with the username 
//Validating the token when requested

//	SecurityConfig :- to enable websecurity
//	SecurityFilterChain: - to add filter for project
//	HttpSecurity:- To add security chain
//	Customizer:- to customize the security
//	AuthenticationProvider:- To define the dao based web security, provide BCryptPasswordEncoder with strength and provide userdetailsservice
//	DaoAuthenticationProvider:- to set database seurity
//	AuthenticationManager:- it manages the complete security(AuthenticationProvider). We need to do custom AuthenticationManager to add jwtsecurity.
//	AuthenticationConfiguration:- 
//	UserDetailsService:- To loadUserByUsername for login. 
//	UserDetails:- to provide username, password , getAuthorities.
//	Jwtfilter:- It extends OncePerRequestFilter, to verify each request once.
//	ApplicationContext:- 
//	JwtService:- to generateToken, extractUserName, validateToken, isTokenExpired, extractExpiration
//	HttpServletRequest:- 
//	HttpServletResponse
//	FilterChain:- 
//	SecurityContextHolder:- 
//	UsernamePasswordAuthenticationToken
//	SecurityContextHolder
//	KeyGenerator
//	Claims:- 
//	Authentication
//	UsernamePasswordAuthenticationToken
//	BCryptPasswordEncoder:- to generate encoded token using username.

}

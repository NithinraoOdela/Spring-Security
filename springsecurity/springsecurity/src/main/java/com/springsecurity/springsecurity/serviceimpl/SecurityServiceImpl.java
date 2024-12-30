package com.springsecurity.springsecurity.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springsecurity.springsecurity.securitydto.MyUserdto;
import com.springsecurity.springsecurity.securityentity.MyUser;
import com.springsecurity.springsecurity.securityentity.Roles;
import com.springsecurity.springsecurity.securityrepository.RoleRepo;
import com.springsecurity.springsecurity.securityrepository.UserRepo;
import com.springsecurity.springsecurity.securityservice.JWTService;
import com.springsecurity.springsecurity.securityservice.UserService;

@Service
public class SecurityServiceImpl implements UserService {
	@Autowired
	public UserRepo userRepo;

	@Autowired
	public AuthenticationManager authenticationManager;

	@Autowired
	public JWTService jwtService;

	@Autowired
	public ModelMapper modelMapper;

	@Autowired
	public RoleRepo roleRepo;

	public BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	public String createUser(MyUserdto userDao) {
		MyUser user = modelMapper.map(userDao, MyUser.class);
		user.setPassword(encoder.encode(user.getPassword()));

		Roles role = roleRepo.findById(1).get();
		user.getRoles().add(role);
		userRepo.save(user);
		return "Saved User";

	}

	public List<MyUserdto> getAllUsers() {

		List<MyUser> users = userRepo.findAll();

		List<MyUserdto> usersDao = users.stream().map(user -> modelMapper.map(user, MyUserdto.class))
				.collect(Collectors.toList());
		return usersDao;
	}

	@Override
	public String loginUser(MyUserdto userDao) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(userDao.getUsername(), userDao.getPassword()));

		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(userDao.getUsername());
		}
		return "failed";

	}
}

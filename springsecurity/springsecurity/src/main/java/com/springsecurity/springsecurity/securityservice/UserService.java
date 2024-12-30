package com.springsecurity.springsecurity.securityservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springsecurity.springsecurity.securitydto.MyUserdto;

@Service
public interface UserService {

	String createUser(MyUserdto userDao);

	List<MyUserdto> getAllUsers();

	String loginUser(MyUserdto userDao);

}

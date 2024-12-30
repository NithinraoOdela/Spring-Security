package com.springsecurity.springsecurity.securityrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.springsecurity.securityentity.MyUser;

@Repository
public interface UserRepo extends JpaRepository<MyUser, Integer> {

	Optional<MyUser> findByUsername(String username);

}

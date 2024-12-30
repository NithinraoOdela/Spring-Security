package com.springsecurity.springsecurity.securityrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.springsecurity.securityentity.Roles;

@Repository
public interface RoleRepo extends JpaRepository<Roles, Integer> {

}

package com.microservices.webservice.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.webservice.restfull.pojo.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}

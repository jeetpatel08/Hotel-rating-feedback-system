package com.micro.userservice.usermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.userservice.usermicroservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}

package com.redox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redox.entity.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, String> {

}

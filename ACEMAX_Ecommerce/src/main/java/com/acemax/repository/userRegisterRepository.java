package com.acemax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acemax.entity.UserData;

@Repository
public interface userRegisterRepository extends JpaRepository<UserData, String> {

}

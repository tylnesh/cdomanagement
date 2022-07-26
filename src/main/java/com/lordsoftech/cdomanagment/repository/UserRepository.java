package com.lordsoftech.cdomanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lordsoftech.cdomanagment.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}

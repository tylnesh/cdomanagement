package com.lordsoftech.cdomanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lordsoftech.cdomanagment.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}

package com.trippi.trippiApp.repository;

import com.trippi.trippiApp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}

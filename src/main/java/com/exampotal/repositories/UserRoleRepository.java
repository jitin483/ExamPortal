package com.exampotal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exampotal.models.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
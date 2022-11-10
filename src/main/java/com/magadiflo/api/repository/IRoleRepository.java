package com.magadiflo.api.repository;

import com.magadiflo.api.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

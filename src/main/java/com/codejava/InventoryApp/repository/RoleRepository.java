package com.codejava.InventoryApp.repository;

import com.codejava.InventoryApp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}

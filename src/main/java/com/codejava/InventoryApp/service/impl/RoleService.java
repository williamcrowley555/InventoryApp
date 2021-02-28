package com.codejava.InventoryApp.service.impl;

import com.codejava.InventoryApp.model.Role;
import com.codejava.InventoryApp.repository.RoleRepository;
import com.codejava.InventoryApp.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        Optional<Role> optional = roleRepository.findById(id);
        Role role = null;
        if (optional.isPresent()) {
            role = optional.get();
        } else {
            throw new RuntimeException("Role ID: " + id + " does not exist");
        }
        return role;
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }
}

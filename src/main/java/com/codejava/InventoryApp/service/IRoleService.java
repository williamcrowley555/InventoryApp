package com.codejava.InventoryApp.service;

import com.codejava.InventoryApp.model.Role;

import java.util.List;

public interface IRoleService {
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    Role saveRole(Role role);
    void deleteRoleById(Long id);
}

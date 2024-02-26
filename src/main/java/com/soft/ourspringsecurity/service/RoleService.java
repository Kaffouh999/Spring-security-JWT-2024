package com.soft.ourspringsecurity.service;

import com.soft.ourspringsecurity.entities.Role;

import java.util.List;

public interface RoleService {
    void saveRole(Role role);
    void updateRole(Role role);
    void deleteRole(Role role);
    Role getRoleById(Long id);
    Role getRoleByName(String name);
    List<Role> getAllRoles();

}

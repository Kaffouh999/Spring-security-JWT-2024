package com.soft.ourspringsecurity.serviceImpl;

import com.soft.ourspringsecurity.entities.Role;
import com.soft.ourspringsecurity.repository.RoleRepository;
import com.soft.ourspringsecurity.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;


    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);

    }

    @Override
    public void updateRole(Role role) {
        roleRepository.save(role);

    }

    @Override
    public void deleteRole(Role role) {
        roleRepository.delete(role);


    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);

    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}

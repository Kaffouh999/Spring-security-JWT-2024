package com.soft.ourspringsecurity.controller;


import com.soft.ourspringsecurity.entities.Role;
import com.soft.ourspringsecurity.enums.Authority;
import com.soft.ourspringsecurity.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", allowCredentials = "true")
@RequestMapping(value = "api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping(value = "")
    public ResponseEntity<Object> createRole(@RequestBody Role role) {
        roleService.saveRole(role);
        return ResponseEntity.ok().body("created");
    }

  @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }


}

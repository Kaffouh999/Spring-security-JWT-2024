package com.soft.ourspringsecurity.entities;

import com.soft.ourspringsecurity.enums.Authority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToOne
    private Role role;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> userAuthorities= new ArrayList<>();
        if(role != null) {
            if (role.isAddRole()) {
                userAuthorities.add(new SimpleGrantedAuthority(Authority.ADD_ROLE.name()));
            }
            if (role.isAddUser()) {
                userAuthorities.add(new SimpleGrantedAuthority(Authority.ADD_USER.name()));
            }
            if (role.isDeleteRole()) {
                userAuthorities.add(new SimpleGrantedAuthority(Authority.DELETE_ROLE.name()));
            }
            if (role.isDeleteUser()) {
                userAuthorities.add(new SimpleGrantedAuthority(Authority.DELETE_USER.name()));
            }
            if (role.isEditRole()) {
                userAuthorities.add(new SimpleGrantedAuthority(Authority.EDIT_ROLE.name()));
            }
            if (role.isEditUser()) {
                userAuthorities.add(new SimpleGrantedAuthority(Authority.EDIT_USER.name()));
            }
        }

        return userAuthorities;
    }


    @Override
    public String getUsername() {
        // email in our case
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

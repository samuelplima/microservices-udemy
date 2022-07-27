package com.udemy.hruser.model.dto;

import com.udemy.hruser.model.entities.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Set<Roles> roles = new HashSet<>();

}



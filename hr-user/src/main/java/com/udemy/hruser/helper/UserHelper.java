package com.udemy.hruser.helper;

import com.udemy.hruser.model.dto.UserDTO;
import com.udemy.hruser.model.entities.User;

public class UserHelper {

    public static UserDTO builderUserDTO(final User user){
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRoles())
                .build();
    }

}

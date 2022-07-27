package com.udemy.hruser.service;

import com.udemy.hruser.model.dto.UserDTO;

public interface UserService {

    UserDTO findByEmail(String email);
    UserDTO findById(Long id);
}

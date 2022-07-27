package com.udemy.hroauth.services;

import com.udemy.hroauth.entities.UserDTO;

public interface UserService {

    UserDTO findByEmail(String email);

}

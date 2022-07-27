package com.udemy.hruser.service.impl;

import com.udemy.hruser.model.dto.UserDTO;
import com.udemy.hruser.model.entities.User;
import com.udemy.hruser.repositories.UserRepository;
import com.udemy.hruser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static com.udemy.hruser.helper.UserHelper.builderUserDTO;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO findByEmail(String email) {
        final User user = userRepository.findByEmail(email);
        return builderUserDTO(user);
    }

    @Override
    public UserDTO findById(Long id) {
        final User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID Not Found"));
        return builderUserDTO(user);
    }
}

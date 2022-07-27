package com.udemy.hroauth.services.impl;

import com.udemy.hroauth.entities.UserDTO;
import com.udemy.hroauth.feignclients.UserFeignClient;
import com.udemy.hroauth.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserService {

    private final UserFeignClient userFeignClient;

    @Override
    public UserDTO findByEmail(String email) {
        final UserDTO userDTO = userFeignClient.findByEmail(email);

        if(Objects.isNull(userDTO)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID Not Found");
        }

        return userDTO;
    }

}

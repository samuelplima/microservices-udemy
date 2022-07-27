package com.udemy.hroauth.services.impl;

import com.udemy.hroauth.entities.UserDTO;
import com.udemy.hroauth.feignclients.UserFeignClient;
import com.udemy.hroauth.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserService, UserDetailsService {

    private final UserFeignClient userFeignClient;

    @Override
    public UserDTO findByEmail(String email) {
        final UserDTO userDTO = userFeignClient.findByEmail(email);

        if(Objects.isNull(userDTO)){
            throw new UsernameNotFoundException("Email not found!");
        }

        return userDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return findByEmail(s);
    }
}

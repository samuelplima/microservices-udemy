package com.udemy.hroauth.controller;

import com.udemy.hroauth.entities.UserDTO;
import com.udemy.hroauth.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/oauth")
@RequiredArgsConstructor
public class OauthController {

    private final UserService userService;

    @GetMapping(value = "/findByEmail/{email}")
    public UserDTO findByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }

}

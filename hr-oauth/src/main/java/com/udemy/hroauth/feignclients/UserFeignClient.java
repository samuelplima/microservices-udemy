package com.udemy.hroauth.feignclients;

import com.udemy.hroauth.entities.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hr-user", path = "/user")
public interface UserFeignClient {

    @GetMapping(value = "/findByEmail/{email}")
    UserDTO findByEmail(@PathVariable String email);

}

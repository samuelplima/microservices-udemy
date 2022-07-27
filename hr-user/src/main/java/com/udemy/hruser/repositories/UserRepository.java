package com.udemy.hruser.repositories;

import com.udemy.hruser.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    User findByEmail(String email);

}

package com.udemy.hrworker.repositories;

import com.udemy.hrworker.model.entities.Workers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository <Workers, Long> {



}

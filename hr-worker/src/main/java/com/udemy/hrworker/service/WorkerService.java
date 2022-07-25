package com.udemy.hrworker.service;

import com.udemy.hrworker.model.dto.WorkerDTO;

import java.util.List;

public interface WorkerService {

    List<WorkerDTO> listAllWorkers();

    WorkerDTO findById(Long id);

}

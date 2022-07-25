package com.udemy.hrworker.controller;

import com.udemy.hrworker.model.dto.WorkerDTO;
import com.udemy.hrworker.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
@RequiredArgsConstructor
public class WorkersController {
    private final WorkerService workerService;

    @GetMapping(value = "/listAll")
    public List<WorkerDTO> listAll(){
        return workerService.listAllWorkers();
    }

    @GetMapping(value = "/findById/{id}")
    public WorkerDTO findById(@PathVariable Long id){
        return workerService.findById(id);
    }

}

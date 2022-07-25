package com.udemy.hrworker.service.impl;

import com.udemy.hrworker.helper.WorkerHelper;
import com.udemy.hrworker.model.dto.WorkerDTO;
import com.udemy.hrworker.model.entities.Workers;
import com.udemy.hrworker.repositories.WorkerRepository;
import com.udemy.hrworker.service.WorkerService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static com.udemy.hrworker.helper.WorkerHelper.builderWorkerDTO;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;

    @Override
    public List<WorkerDTO> listAllWorkers() {
        List<Workers> workersList = workerRepository.findAll();

        return workersList.stream()
                .map(WorkerHelper::builderWorkerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public WorkerDTO findById(Long id) {
        final Workers workers = workerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID Not Found"));
        return builderWorkerDTO(workers);
    }

}

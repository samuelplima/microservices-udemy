package com.udemy.hrworker.helper;

import com.udemy.hrworker.model.dto.WorkerDTO;
import com.udemy.hrworker.model.entities.Workers;

public class WorkerHelper {

    public static WorkerDTO builderWorkerDTO(final Workers workers){
        return WorkerDTO.builder()
                .Id(workers.getId())
                .name(workers.getName())
                .dailyIncome(workers.getDailyIncome())
                .build();
    }

}

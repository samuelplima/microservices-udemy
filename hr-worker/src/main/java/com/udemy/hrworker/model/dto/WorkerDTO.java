package com.udemy.hrworker.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkerDTO {

    private Long Id;
    private String name;
    private Double dailyIncome;

}

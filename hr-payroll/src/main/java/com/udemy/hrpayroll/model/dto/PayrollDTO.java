package com.udemy.hrpayroll.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PayrollDTO {

    private String name;
    private Double dailyIncome;
    private Integer days;

}

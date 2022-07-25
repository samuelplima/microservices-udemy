package com.udemy.hrpayroll.helper;

import com.udemy.hrpayroll.model.dto.PayrollDTO;
import com.udemy.hrpayroll.model.entities.Payroll;

public class PayrollHelper {

    public static PayrollDTO builderWorkerDTO (final Payroll payroll){
        return PayrollDTO.builder()
                .name(payroll.getName())
                .days(payroll.getDays())
                .dailyIncome(payroll.getDailyIncome())
                .build();
    }

}

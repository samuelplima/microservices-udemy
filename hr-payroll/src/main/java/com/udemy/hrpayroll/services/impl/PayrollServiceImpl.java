package com.udemy.hrpayroll.services.impl;

import com.udemy.hrpayroll.model.dto.PayrollDTO;
import com.udemy.hrpayroll.model.entities.Payroll;
import com.udemy.hrpayroll.services.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.udemy.hrpayroll.helper.PayrollHelper.builderWorkerDTO;

@Service
@RequiredArgsConstructor
public class PayrollServiceImpl implements PayrollService {

    @Override
    public PayrollDTO getPayment(Long workerId, Integer days) {
        final Double dailyIncome = 200.00;
        Payroll payroll = new Payroll("Bob", dailyIncome, days);
        payroll.setDailyIncome(dailyIncome*days);

        return builderWorkerDTO(payroll);
    }
}

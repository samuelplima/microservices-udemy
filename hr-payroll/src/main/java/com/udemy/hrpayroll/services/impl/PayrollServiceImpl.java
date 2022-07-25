package com.udemy.hrpayroll.services.impl;

import com.udemy.hrpayroll.feignclients.WorkerFeignClients;
import com.udemy.hrpayroll.model.dto.PayrollDTO;
import com.udemy.hrpayroll.model.dto.WorkerDTO;
import com.udemy.hrpayroll.model.entities.Payroll;
import com.udemy.hrpayroll.services.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.udemy.hrpayroll.helper.PayrollHelper.builderWorkerDTO;

@Service
@RequiredArgsConstructor
public class PayrollServiceImpl implements PayrollService {
    private final WorkerFeignClients workerFeignClients;

    @Override
    public PayrollDTO getPayment(Long workerId, Integer days) {
        final WorkerDTO workerDTO = workerFeignClients.findById(workerId);
        final Payroll payroll = new Payroll(workerDTO.getName(), workerDTO.getDailyIncome(), days);
        return builderWorkerDTO(payroll);
    }
}

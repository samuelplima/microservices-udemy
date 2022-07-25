package com.udemy.hrpayroll.services.impl;

import com.udemy.hrpayroll.model.dto.PayrollDTO;
import com.udemy.hrpayroll.model.dto.WorkerDTO;
import com.udemy.hrpayroll.model.entities.Payroll;
import com.udemy.hrpayroll.services.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static com.udemy.hrpayroll.helper.PayrollHelper.builderWorkerDTO;

@Service
@RequiredArgsConstructor
public class PayrollServiceImpl implements PayrollService {

    @Value("${hr-worker.host}")
    private String workerHost;

    private final RestTemplate restTemplate;


    @Override
    public PayrollDTO getPayment(Long workerId, Integer days) {
        Map<String, String>  uriVariables = new HashMap<>();
        uriVariables.put("id", String.valueOf(workerId));

        final WorkerDTO workerDTO = restTemplate.getForObject(
                workerHost + "/workers/findById/{id}", WorkerDTO.class, uriVariables
        );

        Payroll payroll = new Payroll(workerDTO.getName(), workerDTO.getDailyIncome(), days);

        return builderWorkerDTO(payroll);
    }
}

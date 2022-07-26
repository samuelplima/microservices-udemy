package com.udemy.hrpayroll.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.udemy.hrpayroll.model.dto.PayrollDTO;
import com.udemy.hrpayroll.model.entities.Payroll;
import com.udemy.hrpayroll.services.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.udemy.hrpayroll.helper.PayrollHelper.builderWorkerDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/payroll")
public class PayrollController {

    private final PayrollService payrollService;

    @HystrixCommand(fallbackMethod = "getPaymentByIdAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public PayrollDTO getPaymentById(@PathVariable Long workerId, @PathVariable Integer days) {
        return payrollService.getPayment(workerId, days);
    }

    public PayrollDTO getPaymentByIdAlternative(@PathVariable Long workerId, @PathVariable Integer days){
        Payroll payroll = new Payroll("Bramm", 150.0, days);
        return builderWorkerDTO(payroll);
    }

}

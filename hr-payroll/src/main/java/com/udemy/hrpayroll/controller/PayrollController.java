package com.udemy.hrpayroll.controller;

import com.udemy.hrpayroll.model.dto.PayrollDTO;
import com.udemy.hrpayroll.services.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/payroll")
public class PayrollController {

    private final PayrollService payrollService;

    @GetMapping(value = "/{workerId}/days/{days}")
    @ResponseBody
    public PayrollDTO getPaymentById(@PathVariable Long workerId, @PathVariable Integer days) {
        return payrollService.getPayment(workerId, days);
    }


}

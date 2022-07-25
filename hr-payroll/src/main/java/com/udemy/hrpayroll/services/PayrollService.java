package com.udemy.hrpayroll.services;

import com.udemy.hrpayroll.model.dto.PayrollDTO;

public interface PayrollService {

        PayrollDTO getPayment(Long workerId, Integer days);

}

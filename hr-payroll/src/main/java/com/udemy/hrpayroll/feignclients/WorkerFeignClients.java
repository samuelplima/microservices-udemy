package com.udemy.hrpayroll.feignclients;

import com.udemy.hrpayroll.model.dto.WorkerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hr-worker", url = "localhost:8001/workers")
public interface WorkerFeignClients {

    @GetMapping(value = "/findById/{id}")
    WorkerDTO findById(@PathVariable Long id);

}

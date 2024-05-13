package com.transacoes.controller;

import com.transacoes.domain.dto.operation.request.TransferRequest;
import com.transacoes.domain.dto.operation.response.OperationResponse;
import com.transacoes.domain.mapper.OperationMapper;
import com.transacoes.service.OperationService;
import com.transacoes.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/operation")
public class OperationController {
    @Autowired
    private TaxService taxService;

    @Autowired
    private OperationService operationService;

    @Autowired
    private OperationMapper operationMapper;

    @GetMapping("/{scheduledTransferDate}")
    public Double getTransferTax(@PathVariable String scheduledTransferDate) {
        return taxService.getTaxByScheduledTransferDate(LocalDate.parse(scheduledTransferDate));
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferRequest request)  {
            operationService.transfer(request);
    }

    @GetMapping("/all")
    public List<OperationResponse> getTransferTax() {
        return operationService.getAll().stream().map(operation -> operationMapper.toDto(operation)).toList();
    }
}

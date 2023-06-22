package com.evl.adapplication.history.controller;

import com.evl.adapplication.history.controller.dto.HistoryResponse;
import com.evl.adapplication.history.entity.enums.OperationType;
import com.evl.adapplication.history.service.HistoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping({"history"})
public class HistoryController {

    private final HistoryService service;

    @GetMapping("/account/all/{id}")
    public ResponseEntity<?> getAllAccount(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(service.findAllByCabinetId(id, OperationType.ACCOUNT)
                .stream()
                .map(HistoryResponse::converter)
                .collect(Collectors.toList()));
    }

    @GetMapping("/cabinet/all/{id}")
    public ResponseEntity<?> getAllCabinet(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(service.findAllByCabinetId(id, OperationType.CABINET)
                .stream()
                .map(HistoryResponse::converter)
                .collect(Collectors.toList()));
    }
}

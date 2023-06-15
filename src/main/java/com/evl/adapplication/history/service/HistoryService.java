package com.evl.adapplication.history.service;

import com.evl.adapplication.history.entity.History;
import com.evl.adapplication.history.entity.enums.OperationType;
import com.evl.adapplication.history.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryRepository repository;

    public History save (History history){
        return repository.save(history);
    }

    public List<History> findAllByCabinetId (Long cabinetId, OperationType type){
        return repository.findAllByCabinetIdAndOperationType(cabinetId, type);
    }
}

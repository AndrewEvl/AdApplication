package com.evl.adapplication.history.repository;

import com.evl.adapplication.history.entity.History;
import com.evl.adapplication.history.entity.enums.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    List<History> findAllByCabinetIdAndOperationType(Long cabinetId, OperationType type);
}

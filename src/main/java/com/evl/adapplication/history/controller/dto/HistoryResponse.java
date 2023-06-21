package com.evl.adapplication.history.controller.dto;

import com.evl.adapplication.history.entity.History;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class HistoryResponse {

    private String accountName;
    private LocalDateTime date;
    private Double sum;

    public static HistoryResponse converter(History history) {
        return HistoryResponse.builder()
                .accountName(history.getAccount() != null ? history.getAccount().getName() : "")
                .date(history.getDate())
                .sum(history.getSum())
                .build();
    }
}

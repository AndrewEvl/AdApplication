package com.evl.adapplication.personal_cabinet.controller.dto;

import lombok.Data;

@Data
public class CabinetReplenishRequest {

    private Long cabinetId;
    private Long adAccountId;
    private Double sum;
}

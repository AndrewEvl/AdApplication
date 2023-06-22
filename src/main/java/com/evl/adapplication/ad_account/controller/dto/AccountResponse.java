package com.evl.adapplication.ad_account.controller.dto;

import com.evl.adapplication.ad_account.entity.AdAccount;
import lombok.Builder;

@Builder
public class AccountResponse {

    private Long id;
    private String name;
    private Double balance;
    public static AccountResponse converter (AdAccount adAccount){
        return AccountResponse.builder()
                .id(adAccount.getId())
                .name(adAccount.getName())
                .balance(adAccount.getBalance())
                .build();
    }
}

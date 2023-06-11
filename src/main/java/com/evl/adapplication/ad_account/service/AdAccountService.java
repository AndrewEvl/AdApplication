package com.evl.adapplication.ad_account.service;

import com.evl.adapplication.ad_account.controller.dto.CreatingAdAccountDto;
import com.evl.adapplication.ad_account.repository.AdAccountRepository;
import com.evl.adapplication.personal_cabinet.controller.dto.CabinetReplenishRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdAccountService {

    private final AdAccountRepository repository;

    public void replenishAccount(CabinetReplenishRequest rq){

    }

    public void save (CreatingAdAccountDto rq){

    }
}

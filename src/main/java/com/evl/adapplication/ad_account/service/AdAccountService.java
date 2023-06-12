package com.evl.adapplication.ad_account.service;

import com.evl.adapplication.ad_account.controller.dto.CreatingAdAccountDto;
import com.evl.adapplication.ad_account.entity.AdAccount;
import com.evl.adapplication.ad_account.repository.AdAccountRepository;
import com.evl.adapplication.personal_cabinet.controller.dto.CabinetReplenishRequest;
import com.evl.adapplication.personal_cabinet.entity.PersonalCabinet;
import com.evl.adapplication.personal_cabinet.service.PersonalCabinetService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdAccountService {

    private final AdAccountRepository repository;
    private final PersonalCabinetService personalCabinetService;

    public void replenishAccount(CabinetReplenishRequest rq){
        PersonalCabinet personalCabinet = personalCabinetService.findById(rq.getCabinetId());
        AdAccount adAccount = repository.findById(rq.getAdAccountId()).orElseThrow(EntityNotFoundException::new);
        adAccount.setBalance(adAccount.getBalance() + rq.getSum());
        Double balance = personalCabinet.getBalance();
        personalCabinet.setBalance(balance - rq.getSum());
        personalCabinetService.save(personalCabinet);
        repository.save(adAccount);
    }

    public void save (CreatingAdAccountDto rq){
        PersonalCabinet personalCabinet = personalCabinetService.findById(rq.getCabinetId());
        repository.save(CreatingAdAccountDto.converter(rq, personalCabinet));
    }
}

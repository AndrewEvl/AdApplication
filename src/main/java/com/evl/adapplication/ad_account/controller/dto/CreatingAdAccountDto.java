package com.evl.adapplication.ad_account.controller.dto;

import com.evl.adapplication.ad_account.entity.AdAccount;
import com.evl.adapplication.personal_cabinet.entity.PersonalCabinet;
import lombok.Data;

@Data
public class CreatingAdAccountDto {

    private String serviceType;
    private String name;
    private String site;
    private String theme;
    private Long cabinetId;


    public static AdAccount converter (CreatingAdAccountDto dto, PersonalCabinet cabinet){
        return AdAccount.builder()
                .serviceType(dto.getServiceType())
                .name(dto.getName())
                .site(dto.getSite())
                .balance(0D)
                .cabinet(cabinet)
                .build();
    }
}

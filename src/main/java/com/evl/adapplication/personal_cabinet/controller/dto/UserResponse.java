package com.evl.adversising.personal_cabinet.controller.dto;

import com.evl.adversising.personal_cabinet.entity.PersonalCabinet;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private Long id;
    private String email;
    private String unp;
    private String address;
    private String phoneNumber;
    private String bik;
    private Double balance;

    public static UserResponse converter(PersonalCabinet personalCabinet) {
        return UserResponse.builder()
                .id(personalCabinet.getId())
                .email(personalCabinet.getEmail())
                .unp(personalCabinet.getUnp())
                .address(personalCabinet.getAddress())
                .phoneNumber(personalCabinet.getPhoneNumber())
                .bik(personalCabinet.getBik())
                .balance(personalCabinet.getBalance())
                .build();
    }
}

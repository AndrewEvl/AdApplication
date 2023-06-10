package com.evl.adversising.personal_cabinet.controller.dto;

import com.evl.adversising.personal_cabinet.entity.PersonalCabinet;
import lombok.Data;

@Data
public class UserCreatingRequest {

    private String email;
    private String password;
    private String unp;
    private String address;
    private String phoneNumber;
    private String bik;


    public static PersonalCabinet convector (UserCreatingRequest rq){
        return PersonalCabinet.builder()
                .email(rq.getEmail())
                .password(rq.getPassword())
                .unp(rq.getUnp())
                .address(rq.getAddress())
                .phoneNumber(rq.getPhoneNumber())
                .bik(rq.getBik())
                .build();
    }
}

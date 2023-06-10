package com.evl.adversising.personal_cabinet.controller.dto;

import lombok.Data;

@Data
public class UserLoginRequest {

    private String email;
    private String password;
}

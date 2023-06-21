package com.evl.adapplication.ad_account.controller;

import com.evl.adapplication.ad_account.controller.dto.CreatingAdAccountDto;
import com.evl.adapplication.ad_account.service.AdAccountService;
import com.evl.adapplication.personal_cabinet.controller.dto.CabinetReplenishRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping({"account"})
public class AdController {

    private final AdAccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreatingAdAccountDto rq) {
        accountService.save(rq);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/replenish")
    public ResponseEntity<?> create(@RequestBody CabinetReplenishRequest rq) {
        accountService.replenishAccount(rq);
        return ResponseEntity.ok().build();
    }
}

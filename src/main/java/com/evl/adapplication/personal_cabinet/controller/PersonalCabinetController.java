package com.evl.adapplication.personal_cabinet.controller;


import com.evl.adapplication.personal_cabinet.controller.dto.CabinetReplenishRequest;
import com.evl.adapplication.personal_cabinet.controller.dto.UserCreatingRequest;
import com.evl.adapplication.personal_cabinet.controller.dto.UserLoginRequest;
import com.evl.adapplication.personal_cabinet.controller.dto.UserResponse;
import com.evl.adapplication.personal_cabinet.entity.PersonalCabinet;
import com.evl.adapplication.personal_cabinet.service.PersonalCabinetService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping({"user"})
public class PersonalCabinetController {

    private PersonalCabinetService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest rq) {
        try {
            PersonalCabinet personalCabinet = userService.loginUser(rq);
            return ResponseEntity.ok(UserResponse.converter(personalCabinet));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/login/{id}")
    public ResponseEntity<?> loginId(@PathVariable(value = "id")Long id) {
        try {
            PersonalCabinet personalCabinet = userService.findById(id);
            return ResponseEntity.ok(UserResponse.converter(personalCabinet));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/logout/{id}")
    public ResponseEntity<?> logout(@PathVariable(name = "id") Long id) {
        userService.logout(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/registration")
    public ResponseEntity<?> creatingPersonalCabinet(@RequestBody UserCreatingRequest rq) {
        userService.registration(rq);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/replenish")
    public ResponseEntity<?> replenishCabinet(@RequestBody CabinetReplenishRequest rq) {
        try {
            UserResponse resp = userService.replenish(rq.getCabinetId(), rq.getSum());
            return ResponseEntity.ok(resp);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}

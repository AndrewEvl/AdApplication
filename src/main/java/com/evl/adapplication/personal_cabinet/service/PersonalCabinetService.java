package com.evl.adversising.personal_cabinet.service;

import com.evl.adversising.personal_cabinet.controller.dto.UserCreatingRequest;
import com.evl.adversising.personal_cabinet.controller.dto.UserLoginRequest;
import com.evl.adversising.personal_cabinet.entity.PersonalCabinet;
import com.evl.adversising.personal_cabinet.repository.PersonalCabinetRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonalCabinetService {

    private final PersonalCabinetRepository repository;

    public PersonalCabinet loginUser (UserLoginRequest rq){
        PersonalCabinet personalCabinet = repository.findByEmailAndPassword(rq.getEmail(), rq.getPassword())
                .orElseThrow(EntityNotFoundException::new);
        if(!personalCabinet.isLogin()) {
            personalCabinet.setLogin(true);
            repository.save(personalCabinet);
        }else {
            throw new EntityNotFoundException();
        }
        return personalCabinet;
    }

    public void registration (UserCreatingRequest rq){
        repository.save(UserCreatingRequest.convector(rq));
    }

    public Optional<PersonalCabinet> findByLogin(String login) {
        return repository.findByEmail(login);
    }
}

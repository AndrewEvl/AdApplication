package com.evl.adapplication.personal_cabinet.service;


import com.evl.adapplication.history.entity.History;
import com.evl.adapplication.history.entity.enums.OperationType;
import com.evl.adapplication.history.service.HistoryService;
import com.evl.adapplication.personal_cabinet.controller.dto.UserCreatingRequest;
import com.evl.adapplication.personal_cabinet.controller.dto.UserLoginRequest;
import com.evl.adapplication.personal_cabinet.controller.dto.UserResponse;
import com.evl.adapplication.personal_cabinet.entity.PersonalCabinet;
import com.evl.adapplication.personal_cabinet.repository.PersonalCabinetRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonalCabinetService {

    private final PersonalCabinetRepository repository;
    private final HistoryService historyService;

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

    public void logout (Long id){
        PersonalCabinet cabinet = findById(id);
        cabinet.setLogin(false);
        save(cabinet);
    }

    public PersonalCabinet findById (Long id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void registration (UserCreatingRequest rq){
        repository.save(UserCreatingRequest.convector(rq));
    }

    public Optional<PersonalCabinet> findByLogin(String login) {
        return repository.findByEmail(login);
    }

    public void save (PersonalCabinet personalCabinet){
        repository.save(personalCabinet);
    }

    public UserResponse replenish(Long id, Double sum) {
        Optional<PersonalCabinet> cabinetOptional = repository.findByIdAndLogin(id, true);
        if(cabinetOptional.isPresent()){
            PersonalCabinet personalCabinet = cabinetOptional.get();
            double newBalance = personalCabinet.getBalance() + sum;
            personalCabinet.setBalance(newBalance);
            repository.save(personalCabinet);
            historyService.save(new History(OperationType.CABINET, sum, personalCabinet));
            return UserResponse.converter(personalCabinet);
        } else {
            throw new EntityNotFoundException();
        }
    }
}

package com.evl.adversising.personal_cabinet.repository;

import com.evl.adversising.personal_cabinet.entity.PersonalCabinet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalCabinetRepository extends JpaRepository <PersonalCabinet, Long> {

    Optional<PersonalCabinet> findByEmailAndPassword (@Param("email") String email,
                                                      @Param("password") String password);

    Optional<PersonalCabinet> findByEmail(String login);
}

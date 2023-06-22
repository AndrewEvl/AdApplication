package com.evl.adapplication.personal_cabinet.repository;

import com.evl.adapplication.personal_cabinet.entity.PersonalCabinet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalCabinetRepository extends JpaRepository<PersonalCabinet, Long> {

    Optional<PersonalCabinet> findByEmailAndPassword (@Param("email") String email,
                                                      @Param("password") String password);

    Optional<PersonalCabinet> findByEmail(String login);

    @Query(value = "SELECT pc FROM PersonalCabinet as pc where pc.id = :id AND pc.isLogin = :login")
    Optional<PersonalCabinet> findByIdAndLogin (@Param("id") Long id, @Param("login") boolean isLogin);
}

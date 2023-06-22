package com.evl.adapplication.ad_account.repository;

import com.evl.adapplication.ad_account.entity.AdAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdAccountRepository extends JpaRepository<AdAccount, Long> {

    List<AdAccount> findAllByCabinetId (Long cabinetId);
}

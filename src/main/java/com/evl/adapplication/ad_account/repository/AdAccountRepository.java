package com.evl.adapplication.ad_account.repository;

import com.evl.adapplication.ad_account.entity.AdAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdAccountRepository extends JpaRepository<AdAccount, Long> {
}

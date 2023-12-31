package com.evl.adapplication.personal_cabinet.entity;

import com.evl.adapplication.ad_account.entity.AdAccount;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "personal_cabinet")
public class PersonalCabinet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "unp")
    private String unp;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "bik")
    private String bik;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "is_login")
    private boolean isLogin;

    @OneToMany(mappedBy = "cabinet")
    private Set<AdAccount> adAccountSet;
}

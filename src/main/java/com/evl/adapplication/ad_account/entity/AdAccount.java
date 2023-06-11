package com.evl.adapplication.ad_account.entity;

import com.evl.adapplication.personal_cabinet.entity.PersonalCabinet;
import com.evl.adapplication.personal_cabinet.entity.enums.ServiceType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ad_account")
public class AdAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "service_type")
    @Enumerated(EnumType.ORDINAL)
    private ServiceType serviceType;

    @Column(name = "name")
    private String name;

    @Column(name = "theme")
    private String theme;

    @Column(name = "site")
    private String site;

    @Column(name = "balance")
    private double balance;

    @ManyToOne
    @JoinColumn(name = "cabinet_id")
    private PersonalCabinet cabinet;
}

package com.evl.adapplication.history.entity;

import com.evl.adapplication.ad_account.entity.AdAccount;
import com.evl.adapplication.history.entity.enums.OperationType;
import com.evl.adapplication.personal_cabinet.entity.PersonalCabinet;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    private OperationType operationType;

    @Column(name = "sum")
    private Double sum;

    @ManyToOne
    @JoinColumn(name = "cabinet_id")
    private PersonalCabinet cabinet;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private AdAccount account;

    public History(OperationType operationType, Double sum, PersonalCabinet cabinet, AdAccount account) {
        this.operationType = operationType;
        this.sum = sum;
        this.date = LocalDateTime.now();
        this.cabinet = cabinet;
        this.account = account;
    }

    public History(OperationType operationType, Double sum, PersonalCabinet cabinet) {
        this.operationType = operationType;
        this.sum = sum;
        this.date = LocalDateTime.now();
        this.cabinet = cabinet;
    }
}

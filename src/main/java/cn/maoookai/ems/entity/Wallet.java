package cn.maoookai.ems.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "wallet")
public class Wallet {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "operate")
    private String operate;

    @Column(name = "old_balance")
    private String oldBalance;

    @Column(name = "new_balance")
    private String newBalance;

    @Column(name = "operate_time")
    private String operateTime;

}

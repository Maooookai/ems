package cn.maoookai.ems.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "current")
public class Current {

    @GeneratedValue
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "used")
    private String used;

    @Column(name = "last_update_time")
    private String updateTime;

}

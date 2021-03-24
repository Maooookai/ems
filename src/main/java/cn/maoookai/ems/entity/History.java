package cn.maoookai.ems.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "history")
public class History {

    @GeneratedValue
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "used")
    private String used;

    @Column(name = "date")
    private String time;

}

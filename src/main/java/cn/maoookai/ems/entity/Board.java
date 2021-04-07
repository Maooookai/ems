package cn.maoookai.ems.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "board")
public class Board {

    @GeneratedValue
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "content")
    private String content;

    @Column(name = "update_time")
    private String updateTime;

    @Column(name = "is_deleted")
    private boolean deleted;

}

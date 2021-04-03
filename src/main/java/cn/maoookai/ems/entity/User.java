package cn.maoookai.ems.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {

    @GeneratedValue
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "elect_type")
    private boolean electType;

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "is_admin")
    private boolean admin;

    @Column(name = "register_time")
    private String registerTime;

}

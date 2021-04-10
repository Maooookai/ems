package cn.maoookai.ems.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "price")
public class Price {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "date")
    private String date;

    @Column(name = "price")
    private String price;

    @Column(name = "elect_type")
    private boolean electType;

}

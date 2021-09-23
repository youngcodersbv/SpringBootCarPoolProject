package com.example.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "commute", schema = "public")
public class Commute {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String home;

    @Column(nullable = false)
    private String work;

    @ManyToOne(targetEntity = User.class)
    private User user;
}

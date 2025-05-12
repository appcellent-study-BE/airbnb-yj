package com.example.airbnb_clonecoding.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HOST_ID")
    private int hostId;

    @OneToOne
    private Member userId;

    private LocalDate hostDate;

    private boolean isEmail;

    private boolean isPhoneNum;
}
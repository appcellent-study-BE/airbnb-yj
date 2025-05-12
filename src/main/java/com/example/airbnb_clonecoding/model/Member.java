package com.example.airbnb_clonecoding.model;

import com.example.airbnb_clonecoding.model.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int userId;

    @Column(length = 20)
    private String userName;

    @Column(length = 20)
    private String userLoginId;

    @Column(length = 20)
    private String userPassword;

    @Column(length = 255)
    private String userEmail;

    @Column(length = 13)
    private String userPhoneNum;

    private LocalDate userDOB;

    private boolean isHost;

    private LocalDate registerDate;

    private Gender userGender;

    private boolean isCertificate;
}
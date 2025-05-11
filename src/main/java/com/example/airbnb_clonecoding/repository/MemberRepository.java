package com.example.airbnb_clonecoding.repository;

import com.example.airbnb_clonecoding.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Boolean existsByUserName(String userName);
}
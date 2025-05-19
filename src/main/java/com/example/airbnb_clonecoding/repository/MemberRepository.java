package com.example.airbnb_clonecoding.repository;

import com.example.airbnb_clonecoding.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Boolean existsByUserName(String userName);

    // userName을 받아 DB에서 회원 조회
    Member findByUserName(String userName);
}
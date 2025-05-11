package com.example.airbnb_clonecoding.service;

import com.example.airbnb_clonecoding.dto.MemberDto;
import com.example.airbnb_clonecoding.model.Member;
import com.example.airbnb_clonecoding.repository.MemberRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignupService {

    private final MemberRepository memberRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public SignupService(MemberRepository memberRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.memberRepository = memberRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void signupProcess(MemberDto memberDto) {

        String userName = memberDto.getUserName();
        String userPassword = memberDto.getUserPassword();

        Boolean isExist = memberRepository.existsByUserName(userName);

        if (isExist) {

            return;
        }

        Member member = new Member();

        member.setUserName(userName);
        member.setUserPassword(bCryptPasswordEncoder.encode(userPassword));

        memberRepository.save(member);
    }
}
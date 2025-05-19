package com.example.airbnb_clonecoding.service;

import com.example.airbnb_clonecoding.model.Member;
import com.example.airbnb_clonecoding.repository.MemberRepository;
import com.example.airbnb_clonecoding.dto.CustomUserDetailsDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public CustomUserDetailsService(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Member memberData = memberRepository.findByUserName(userName);

        if (memberData != null) {
            return new CustomUserDetailsDto(memberData);
        }

        return null;
    }
}
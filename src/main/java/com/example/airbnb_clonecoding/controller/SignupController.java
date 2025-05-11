package com.example.airbnb_clonecoding.controller;

import com.example.airbnb_clonecoding.dto.MemberDto;
import com.example.airbnb_clonecoding.service.SignupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class SignupController {

    private final SignupService signupService;

    public SignupController(SignupService signupService) {

        this.signupService = signupService;
    }

    @PostMapping("/signup")
    public String signupProcess(MemberDto memberDto) {

        System.out.println("userName: " + memberDto.getUserName());
        System.out.println("userPassword: " + memberDto.getUserPassword());

        signupService.signupProcess(memberDto);

        return "success";
    }
}
package com.example.airbnb_clonecoding.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainpageController {

    @GetMapping("/")
    public String mainpage() {

        return "mainpage controller";
    }
}

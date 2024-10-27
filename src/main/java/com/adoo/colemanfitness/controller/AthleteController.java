package com.adoo.colemanfitness.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class AthleteController {

    @GetMapping("/main")
    public String defaultMethod(){
        return "Hello world";
    }
}

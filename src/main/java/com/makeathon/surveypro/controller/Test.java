package com.makeathon.surveypro.controller;

import com.makeathon.surveypro.security.CurrentUser;
import com.makeathon.surveypro.security.UserPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Test {


    @GetMapping("/getHello")
    public String getAchievementListByUserId(@CurrentUser UserPrincipal userPrincipal) {
        System.out.println(userPrincipal.getEmail() + " " + userPrincipal.getUsername());
        return "hello";
    }

}

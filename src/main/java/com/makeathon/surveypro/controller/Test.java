package com.makeathon.surveypro.controller;

import com.makeathon.surveypro.security.CurrentUser;
import com.makeathon.surveypro.security.UserPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class Test {


    @GetMapping("/getHello")
    public String getAchievementListByUserId(@CurrentUser UserPrincipal userPrincipal) {
        System.out.println(userPrincipal.getEmail() + " " + userPrincipal.getUsername());
        return "hello";
    }


}

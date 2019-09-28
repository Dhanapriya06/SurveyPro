package com.makeathon.surveypro.controller;

import com.makeathon.surveypro.model.request.SurveyRequest;
import com.makeathon.surveypro.security.CurrentUser;
import com.makeathon.surveypro.security.UserPrincipal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class SurveyGeneratorController {


    @PostMapping("/create/survey")
    public String getAchievementListByUserId(@RequestBody SurveyRequest surveyRequest) {
        System.out.println(surveyRequest);
        return "hello";
    }

}

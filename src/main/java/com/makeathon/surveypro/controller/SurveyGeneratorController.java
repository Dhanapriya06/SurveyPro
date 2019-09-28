package com.makeathon.surveypro.controller;

import com.makeathon.surveypro.entity.SurveyEntity;
import com.makeathon.surveypro.model.request.QuestionRequest;
import com.makeathon.surveypro.model.request.SurveyRequest;
import com.makeathon.surveypro.model.response.APIResponse;
import com.makeathon.surveypro.security.CurrentUser;
import com.makeathon.surveypro.security.UserPrincipal;
import com.makeathon.surveypro.service.SurveyQuestionServiceImpl;
import com.makeathon.surveypro.service.SurveyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SurveyGeneratorController {
    @Autowired
    SurveyServiceImpl surveyServiceImpl;

    @Autowired
    SurveyQuestionServiceImpl surveyQuestionServiceImpl;

    @PostMapping("/create/survey")
    public ResponseEntity<?> createSurvey(@RequestBody SurveyRequest surveyRequest) {
        SurveyEntity surveyId = surveyServiceImpl.insertSurvey(surveyRequest, 1L);
        List<QuestionRequest> list = surveyRequest.getQuestionRequestList();
        surveyQuestionServiceImpl.addAllQuestion(list, surveyId);
        return ResponseEntity.ok(new APIResponse(false, "Survey created successfully"));
    }


    @PostMapping("/create/survey1")
    public ResponseEntity<?> createSurvey1(@CurrentUser UserPrincipal userPrincipal, @RequestBody SurveyRequest surveyRequest) {
        SurveyEntity surveyId = surveyServiceImpl.insertSurvey(surveyRequest, userPrincipal.getId());
        List<QuestionRequest> list = surveyRequest.getQuestionRequestList();
        surveyQuestionServiceImpl.addAllQuestion(list, surveyId);
        return ResponseEntity.ok(new APIResponse(false, "Survey created successfully"));
    }

    @GetMapping("get/allOpenSurveys")
    public ResponseEntity<?> getAllSurveys(){

        return ResponseEntity.ok(surveyServiceImpl.getAllOpenSurveys());
    }




}

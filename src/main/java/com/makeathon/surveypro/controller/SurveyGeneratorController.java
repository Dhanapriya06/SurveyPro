package com.makeathon.surveypro.controller;

import com.makeathon.surveypro.entity.SurveyEntity;
import com.makeathon.surveypro.model.request.QuestionRequest;
import com.makeathon.surveypro.model.request.SurveyRequest;
import com.makeathon.surveypro.model.response.APIResponse;
import com.makeathon.surveypro.service.SurveyQuestionServiceImpl;
import com.makeathon.surveypro.service.SurveyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        SurveyEntity surveyId = surveyServiceImpl.insertSurvey(surveyRequest);
        List<QuestionRequest> list = surveyRequest.getQuestionRequestList();
        surveyQuestionServiceImpl.addAllQuestion(list, surveyId);
        return ResponseEntity.ok(new APIResponse(false, "Survey created successfully"));
    }

}

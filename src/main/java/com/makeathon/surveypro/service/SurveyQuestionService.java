package com.makeathon.surveypro.service;

import com.makeathon.surveypro.entity.SurveyEntity;
import com.makeathon.surveypro.model.request.QuestionRequest;

import java.util.List;

public interface SurveyQuestionService {
    public void addAllQuestion(List<QuestionRequest> questions, SurveyEntity surveyId);
}

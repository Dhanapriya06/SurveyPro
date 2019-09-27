package com.makeathon.surveypro.service;

import com.makeathon.surveypro.entity.SurveyEntity;

import java.util.List;

public interface SurveyService {
    public void insertSurvey(SurveyEntity survey);
    public void updateSurvey(int surveyId);
    public List<SurveyEntity> getSurveyByUserId(int userId);
    public SurveyEntity getSurveyBySurveyId(int surveyId);
    public void deleteSurvey(int surveyId);
}

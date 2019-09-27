package com.makeathon.surveypro.repository;

import com.makeathon.surveypro.entity.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyRepository extends JpaRepository<SurveyEntity,Integer> {
    List<SurveyEntity> findByUserId(int userId);
    SurveyEntity findBySurveyId(int surveyId);
}

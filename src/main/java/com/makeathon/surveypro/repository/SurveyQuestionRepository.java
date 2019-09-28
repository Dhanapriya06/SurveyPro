package com.makeathon.surveypro.repository;

import com.makeathon.surveypro.entity.SurveyQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyQuestionRepository extends JpaRepository<SurveyQuestion, Integer> {
}

package com.makeathon.surveypro.repository;

import com.makeathon.surveypro.entity.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyRepository extends JpaRepository<SurveyEntity,Integer> {
    List<SurveyEntity> findByUser_UserId(int userId);
    @Override
    Optional<SurveyEntity> findById(Integer integer);
}

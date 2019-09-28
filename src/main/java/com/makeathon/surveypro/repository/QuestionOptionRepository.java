package com.makeathon.surveypro.repository;

import com.makeathon.surveypro.entity.QuestionOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionOptionRepository extends JpaRepository<QuestionOption, Integer> {
}

package com.makeathon.surveypro.service;

import com.makeathon.surveypro.entity.AnswerType;
import com.makeathon.surveypro.entity.QuestionOption;
import com.makeathon.surveypro.entity.SurveyEntity;
import com.makeathon.surveypro.entity.SurveyQuestion;
import com.makeathon.surveypro.model.request.QuestionRequest;
import com.makeathon.surveypro.repository.AnswerTypeRepository;
import com.makeathon.surveypro.repository.QuestionOptionRepository;
import com.makeathon.surveypro.repository.SurveyQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyQuestionServiceImpl implements SurveyQuestionService {
    @Autowired
    SurveyQuestionRepository surveyQuestionRepository;
    @Autowired
    AnswerTypeRepository answerTypeRepository;
    @Autowired
    QuestionOptionRepository questionOptionRepository;

    @Override
    public void addAllQuestion(List<QuestionRequest> questions, SurveyEntity surveyId) {
        for (QuestionRequest question : questions
        ) {
            SurveyQuestion sq = new SurveyQuestion();
            sq.setSurvey(surveyId);
            sq.setQuestion(question.getQuestion());
            Optional<AnswerType> at = answerTypeRepository.findById((long) question.getQuestionType());
            sq.setAnswerType(at.get());
            SurveyQuestion sq1 = surveyQuestionRepository.save(sq);
            List<String> list = question.getQuestionOptions();
            for (String s : list
            ) {
                QuestionOption option = new QuestionOption();
                option.setSurvey(sq1);
                option.setOptionValue(s);
                System.out.println(s);
                questionOptionRepository.save(option);
                List<QuestionOption> q = questionOptionRepository.findAll();
                for (QuestionOption qqq : q
                ) {
                    System.out.println(qqq.getOptionValue());
                }
            }
        }
    }
}

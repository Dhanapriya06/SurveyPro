package com.makeathon.surveypro.entity;

import javax.persistence.*;

@Entity
public class AnswerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answertype_id")
    private long answerTypeId;
    private String answerTypeName;

    public long getAnswerTypeId() {
        return answerTypeId;
    }

    public void setAnswerTypeId(long answerTypeId) {
        this.answerTypeId = answerTypeId;
    }

    public String geteAnswerTypeName() {
        return answerTypeName;
    }

    public void setAnswerTypeName(String username) {
        this.answerTypeName = answerTypeName;
    }
}

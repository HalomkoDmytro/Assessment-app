package com.drunkhorse.assesmentapp.service;

import com.drunkhorse.assesmentapp.model.Answer;
import com.drunkhorse.assesmentapp.model.dto.AnswerDto;
import com.drunkhorse.assesmentapp.model.request.CheckAnswerRequest;
import com.drunkhorse.assesmentapp.model.request.CheckAnswerResponse;

import java.util.List;
import java.util.Optional;

public interface AnswerService {

    List<Answer> findByQuestion(Long questionId);

    Optional<Answer> findById(Long id);

    Answer createOrUpdate(AnswerDto answer);

    Answer createOrUpdate(Answer answer);

    void deleteById(Long id);

    CheckAnswerResponse checkAnswer(CheckAnswerRequest request);

}

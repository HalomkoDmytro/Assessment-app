package com.drunkhorse.assesmentapp.service;

import com.drunkhorse.assesmentapp.model.Question;
import com.drunkhorse.assesmentapp.model.dto.QuestionDto;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    Optional<Question> findById(Long id);

    Question getById(Long id, boolean hideAnswer);

    List<Question> findAll();

    List<Question> findAllByExamId(Long examId);

    Question createOrUpdate(QuestionDto dto);

    Question createOrUpdate(Question question);

    void deleteById(Long id);

    List<Question> findAllByExamIdLimit(Long examId, int limit);

    Question getRandomQuestion(Long examId);

}

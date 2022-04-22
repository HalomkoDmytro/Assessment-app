package com.drunkhorse.assesmentapp.service.impl;

import com.drunkhorse.assesmentapp.converter.AnswerConverter;
import com.drunkhorse.assesmentapp.exeption.ResourceNotFoundException;
import com.drunkhorse.assesmentapp.model.Answer;
import com.drunkhorse.assesmentapp.model.Question;
import com.drunkhorse.assesmentapp.model.dto.AnswerDto;
import com.drunkhorse.assesmentapp.repository.AnswerRepository;
import com.drunkhorse.assesmentapp.service.AnswerService;
import com.drunkhorse.assesmentapp.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionService questionService;

    @Override
    public List<Answer> findByQuestion(Long questionId) {
        return answerRepository.findAllByQuestion_Id(questionId);
    }

    @Override
    public Optional<Answer> findById(Long id) {
        return answerRepository.findById(id);
    }

    @Override
    public Answer createOrUpdate(AnswerDto dto) {
        Question question = questionService.findById(dto.questionId()).orElseThrow(ResourceNotFoundException::new);
        Answer answer = createOrUpdate(AnswerConverter.convert(dto));
        answer.setQuestion(question);
        return answer;
    }

    @Override
    public Answer createOrUpdate(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public void deleteById(Long id) {
        answerRepository.deleteById(id);
    }

}

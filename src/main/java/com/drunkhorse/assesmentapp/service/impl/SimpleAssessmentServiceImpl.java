package com.drunkhorse.assesmentapp.service.impl;

import com.drunkhorse.assesmentapp.converter.QuestionConverter;
import com.drunkhorse.assesmentapp.exeption.ResourceNotFoundException;
import com.drunkhorse.assesmentapp.model.Question;
import com.drunkhorse.assesmentapp.model.dto.QuestionDto;
import com.drunkhorse.assesmentapp.model.request.QuestionRequest;
import com.drunkhorse.assesmentapp.service.QuestionService;
import com.drunkhorse.assesmentapp.service.SimpleAssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SimpleAssessmentServiceImpl implements SimpleAssessmentService {

    private final QuestionService questionService;

    @Override
    public QuestionDto getQuestion(QuestionRequest request) {
        if(request.getId() != null) {
            return QuestionConverter.toDto(questionService.findById(request.getId())
                    .orElseThrow(ResourceNotFoundException::new));
        }
        List<Question> allByExamId = questionService.findAllByExamId(request.getExamId());
        Collections.shuffle(allByExamId);
        return QuestionConverter.toDto(allByExamId.get(0));
    }
}

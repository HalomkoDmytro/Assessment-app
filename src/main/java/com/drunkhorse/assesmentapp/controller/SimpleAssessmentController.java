package com.drunkhorse.assesmentapp.controller;

import com.drunkhorse.assesmentapp.model.dto.QuestionDto;
import com.drunkhorse.assesmentapp.model.request.QuestionRequest;
import com.drunkhorse.assesmentapp.service.SimpleAssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/simple-assessment"))
@RequiredArgsConstructor
public class SimpleAssessmentController {

    private final SimpleAssessmentService simpleAssessmentService;

    @PostMapping
    public QuestionDto getQuestion(@RequestBody QuestionRequest request) {
        return simpleAssessmentService.getQuestion(request);
    }
}

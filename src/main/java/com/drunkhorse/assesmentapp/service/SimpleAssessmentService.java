package com.drunkhorse.assesmentapp.service;

import com.drunkhorse.assesmentapp.model.dto.QuestionDto;
import com.drunkhorse.assesmentapp.model.request.QuestionRequest;

public interface SimpleAssessmentService {


    QuestionDto getQuestion(QuestionRequest questionRequest);
}

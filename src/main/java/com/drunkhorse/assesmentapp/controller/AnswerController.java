package com.drunkhorse.assesmentapp.controller;

import com.drunkhorse.assesmentapp.model.request.CheckAnswerRequest;
import com.drunkhorse.assesmentapp.model.request.CheckAnswerResponse;
import com.drunkhorse.assesmentapp.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/answers"))
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping("/check")
    public CheckAnswerResponse checkAnswer(@RequestBody CheckAnswerRequest request) {
        return answerService.checkAnswer(request);
    }
    
}

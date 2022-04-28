package com.drunkhorse.assesmentapp.controller;

import com.drunkhorse.assesmentapp.exeption.ResourceNotFoundException;
import com.drunkhorse.assesmentapp.model.Question;
import com.drunkhorse.assesmentapp.model.dto.QuestionDto;
import com.drunkhorse.assesmentapp.model.request.QuestionRequest;
import com.drunkhorse.assesmentapp.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(("/questions"))
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public List<Question> findAll() {
        return questionService.findAll();
    }

    @GetMapping("/{id}")
    public Question byId(@PathVariable Long id) {
        return questionService.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping("/exam/{examId}")
    public List<Question> byExamId(@PathVariable Long examId) {
        return questionService.findAllByExamId(examId);
    }

    @PostMapping
    public Question save(@RequestBody QuestionDto dto) {
        return questionService.createOrUpdate(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        questionService.deleteById(id);
    }

    @PostMapping("/exam")
    public List<Question> byExamWithLimit(@RequestBody QuestionRequest request) {
        return questionService.findAllByExamIdLimit(request.getExamId(), request.getLimit());
    }

    @GetMapping("/exams/{examId}/random")
    public Question getRandomQuestion(@PathVariable Long examId) {
        return questionService.getRandomQuestion(examId);
    }

}

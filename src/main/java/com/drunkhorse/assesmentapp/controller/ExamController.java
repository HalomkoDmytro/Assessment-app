package com.drunkhorse.assesmentapp.controller;

import com.drunkhorse.assesmentapp.converter.ExamConverter;
import com.drunkhorse.assesmentapp.exeption.ResourceNotFoundException;
import com.drunkhorse.assesmentapp.model.Exam;
import com.drunkhorse.assesmentapp.model.dto.ExamDto;
import com.drunkhorse.assesmentapp.model.request.ExamRequest;
import com.drunkhorse.assesmentapp.service.ExamService;
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
@RequestMapping(("/exams"))
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;

    @GetMapping
    public List<Exam> findAll() {
        return examService.findAll();
    }

    @PostMapping("/tags")
    public List<Exam> byTags(@RequestBody ExamRequest request) {
        return examService.findAllByTags(request.getTags());
    }

    @GetMapping("/{id}")
    public Exam byId(@PathVariable Long id) {
        return examService.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @PostMapping
    public Exam crete(@RequestBody ExamDto dto) {
        return examService.createOrUpdate(ExamConverter.convert(dto));
    }

    @PostMapping("/test")
    public ExamDto test(@RequestBody ExamDto dto) {
        return dto;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        examService.deleteById(id);
    }

}

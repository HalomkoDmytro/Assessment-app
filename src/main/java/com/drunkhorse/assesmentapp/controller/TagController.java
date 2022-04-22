package com.drunkhorse.assesmentapp.controller;

import com.drunkhorse.assesmentapp.model.ExamTag;
import com.drunkhorse.assesmentapp.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(("/tags"))
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping
    public List<ExamTag> findAll() {
        return tagService.findAll();
    }
}

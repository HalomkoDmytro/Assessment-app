package com.drunkhorse.assesmentapp.service.impl;

import com.drunkhorse.assesmentapp.model.ExamTag;
import com.drunkhorse.assesmentapp.repository.ExamTagsRepository;
import com.drunkhorse.assesmentapp.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final ExamTagsRepository examTagsRepository;

    @Override
    public List<ExamTag> findAll() {
        return examTagsRepository.findAll();
    }
}

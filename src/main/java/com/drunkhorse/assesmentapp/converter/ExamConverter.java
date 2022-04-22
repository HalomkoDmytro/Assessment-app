package com.drunkhorse.assesmentapp.converter;

import com.drunkhorse.assesmentapp.model.Exam;
import com.drunkhorse.assesmentapp.model.ExamTag;
import com.drunkhorse.assesmentapp.model.dto.ExamDto;

import java.util.List;

public final class ExamConverter {

    public static Exam convert(ExamDto dto) {

        List<ExamTag> examTags = dto.tags()
                .stream()
                .map(ExamTag::new)
                .toList();

        return Exam.builder()
                .id(dto.id())
                .description(dto.description())
                .isTest(dto.isTest())
                .language(dto.language())
                .tags(examTags)
                .title(dto.title())
                .year(dto.year())
                .build();
    }
}

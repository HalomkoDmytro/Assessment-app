package com.drunkhorse.assesmentapp.converter;

import com.drunkhorse.assesmentapp.model.Exam;
import com.drunkhorse.assesmentapp.model.ExamTag;
import com.drunkhorse.assesmentapp.model.dto.ExamDto;

import java.util.List;

public final class ExamConverter {

    private ExamConverter() {
    }

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

    public static ExamDto toDto(Exam exam) {

        List<String> tags = exam.getTags()
                .stream()
                .map(ExamTag::getTag)
                .toList();

        return new ExamDto(exam.getId(),
                exam.getTitle(),
                exam.getYear(),
                exam.getDescription(),
                exam.getLanguage(),
                exam.isTest(),
                tags);
    }
}

package com.drunkhorse.assesmentapp.converter;

import com.drunkhorse.assesmentapp.model.Answer;
import com.drunkhorse.assesmentapp.model.dto.AnswerDto;

public final class AnswerConverter {

    public static Answer convert(AnswerDto dto) {
        return Answer.builder()
                .id(dto.id())
                .isCorrect(dto.isCorrect())
                .text(dto.text())
                .build();
    }

    public static AnswerDto toDtoShort(Answer answer) {
        return new AnswerDto(answer.getId(),
                answer.getText(),
                false,
                answer.getQuestion().getId());
    }

    public static AnswerDto toDto(Answer answer) {
        return new AnswerDto(answer.getId(),
                answer.getText(),
                answer.isCorrect(),
                answer.getQuestion().getId());
    }
}

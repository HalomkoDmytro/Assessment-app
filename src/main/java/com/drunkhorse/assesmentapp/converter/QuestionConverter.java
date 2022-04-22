package com.drunkhorse.assesmentapp.converter;

import com.drunkhorse.assesmentapp.model.Answer;
import com.drunkhorse.assesmentapp.model.Question;
import com.drunkhorse.assesmentapp.model.dto.AnswerDto;
import com.drunkhorse.assesmentapp.model.dto.QuestionDto;

import java.util.List;

public final class QuestionConverter {

    public static Question convert(QuestionDto dto) {

        List<Answer> answers = null;
        if (dto.answers() != null) {
            answers = dto.answers()
                    .stream()
                    .map(AnswerConverter::convert)
                    .toList();
        }

        return Question.builder()
                .id(dto.id())
                .text(dto.text())
                .ticketId(dto.ticketId())
                .img(dto.img())
                .isMultipleCorrect(dto.isMultipleCorrect())
                .explanationAnswer(dto.explanationAnswer())
                .answers(answers)
                .build();
    }

    public static QuestionDto toDtoShort(Question question) {

        List<AnswerDto> answerDtos = question.getAnswers().stream()
                .map(AnswerConverter::toDtoShort)
                .toList();

        return new QuestionDto(question.getId(),
                question.getText(),
                question.getTicketId(),
                question.getImg(),
                question.isMultipleCorrect(),
                null,
                answerDtos,
                question.getExam().getId()
        );
    }

    public static QuestionDto toDto(Question question) {

        List<AnswerDto> answerDtos = question.getAnswers().stream()
                .map(AnswerConverter::toDto)
                .toList();

        return new QuestionDto(question.getId(),
                question.getText(),
                question.getTicketId(),
                question.getImg(),
                question.isMultipleCorrect(),
                question.getExplanationAnswer(),
                answerDtos,
                question.getExam().getId()
        );
    }
}

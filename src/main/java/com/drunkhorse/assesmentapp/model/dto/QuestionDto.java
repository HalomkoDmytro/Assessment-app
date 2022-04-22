package com.drunkhorse.assesmentapp.model.dto;

import java.util.List;

public record QuestionDto(Long id,
                          String text,
                          Long ticketId,
                          String img,
                          boolean isMultipleCorrect,
                          String explanationAnswer,
                          List<AnswerDto> answers,
                          Long examId) {
}

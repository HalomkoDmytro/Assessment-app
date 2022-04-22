package com.drunkhorse.assesmentapp.model.dto;

public record AnswerDto(Long id,
                        String text,
                        boolean isCorrect,
                        Long questionId) {
}

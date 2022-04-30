package com.drunkhorse.assesmentapp.model.request;

import java.util.List;

public record CheckAnswerResponse(Long questionId, boolean isCorrect, List<Long> correctAnswersId, String description) {
}

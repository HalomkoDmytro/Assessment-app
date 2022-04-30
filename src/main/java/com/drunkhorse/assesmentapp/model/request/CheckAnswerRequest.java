package com.drunkhorse.assesmentapp.model.request;

import java.util.List;

public record CheckAnswerRequest(Long questionId, List<Long> answerList) {
}

package com.drunkhorse.assesmentapp.model.dto;

import com.drunkhorse.assesmentapp.model.Language;

import java.util.List;


public record ExamDto(Long id,
                      String title,
                      Long year,
                      String description,
                      Language language,
                      boolean isTest,
                      List<String> tags) {
}

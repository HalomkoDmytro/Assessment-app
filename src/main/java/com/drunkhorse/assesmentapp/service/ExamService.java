package com.drunkhorse.assesmentapp.service;

import com.drunkhorse.assesmentapp.model.Exam;
import com.drunkhorse.assesmentapp.model.dto.ExamDto;
import com.drunkhorse.assesmentapp.model.dto.Paging;

import java.util.List;
import java.util.Optional;

public interface ExamService {

    List<Exam> findAll();

    List<Exam> findAllLight();

    List<Exam> findAllByTags(List<String> tags);

    Optional<Exam> findById(Long id);

    Exam createOrUpdate(ExamDto exam);

    Exam createOrUpdate(Exam exam);

    void deleteById(Long id);

    Exam findByQuestionId(Long questionId);
}

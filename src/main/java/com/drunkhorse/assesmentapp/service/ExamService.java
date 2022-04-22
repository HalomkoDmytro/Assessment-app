package com.drunkhorse.assesmentapp.service;

import com.drunkhorse.assesmentapp.model.Exam;
import com.drunkhorse.assesmentapp.model.ExamTag;
import com.drunkhorse.assesmentapp.model.dto.ExamDto;

import java.util.List;
import java.util.Optional;

public interface ExamService {

    List<Exam> findAll();

    List<Exam> findAllByTags(List<ExamTag> tags);

    Optional<Exam> findById(Long id);

    Exam createOrUpdate(ExamDto exam);

    Exam createOrUpdate(Exam exam);

    void deleteById(Long id);
}

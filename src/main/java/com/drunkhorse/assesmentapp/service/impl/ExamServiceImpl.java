package com.drunkhorse.assesmentapp.service.impl;

import com.drunkhorse.assesmentapp.converter.ExamConverter;
import com.drunkhorse.assesmentapp.exeption.ResourceNotFoundException;
import com.drunkhorse.assesmentapp.model.Exam;
import com.drunkhorse.assesmentapp.model.dto.ExamDto;
import com.drunkhorse.assesmentapp.model.dto.Pagging;
import com.drunkhorse.assesmentapp.repository.ExamRepository;
import com.drunkhorse.assesmentapp.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;

    @Override
    public List<Exam> findAll(Pagging pagging) {
        Pageable pageable = PageRequest.of(pagging.limit(), pagging.offset());
        Page<Exam> pageAll = examRepository.findAll(pageable);
        return pageAll.stream().toList();
    }

    @Override
    public List<Exam> findAllByTags(List<String> tags, Pagging pagging) {
        Pageable pageable = PageRequest.of(pagging.limit(), pagging.offset());
        return examRepository.findAllByTags(tags, pageable);
    }

    @Override
    public Optional<Exam> findById(Long id) {
        return examRepository.findById(id);
    }

    @Override
    public Exam createOrUpdate(ExamDto exam) {
        return createOrUpdate(ExamConverter.convert(exam));
    }

    @Override
    public Exam createOrUpdate(Exam exam) {
        if(exam.getId() == null) {
            return examRepository.save(exam);
        }

        Exam examOld = examRepository.findById(exam.getId()).orElseThrow(ResourceNotFoundException::new);
        examOld.setTags(exam.getTags());
        examOld.setTitle(exam.getTitle());
        examOld.setDescription(exam.getDescription());
        examOld.setYear(exam.getYear());

        return examRepository.save(examOld);
    }

    @Override
    public void deleteById(Long id) {
        examRepository.deleteById(id);
    }
}

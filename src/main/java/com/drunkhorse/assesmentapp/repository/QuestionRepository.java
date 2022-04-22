package com.drunkhorse.assesmentapp.repository;

import com.drunkhorse.assesmentapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findAllByExam_Id(Long examId);

}

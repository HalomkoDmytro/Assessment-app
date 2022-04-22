package com.drunkhorse.assesmentapp.repository;

import com.drunkhorse.assesmentapp.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findAllByQuestion_Id(Long questionId);
}

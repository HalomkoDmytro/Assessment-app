package com.drunkhorse.assesmentapp.repository;

import com.drunkhorse.assesmentapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findAllByExam_Id(Long examId);

    @Query(value = "SELECT q.id FROM question q " +
            " INNER JOIN exam e on e.id = q.exam_id " +
            " WHERE e.id = :examId " +
            " ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Long getRandomQuestionIdForExam(Long examId);

}

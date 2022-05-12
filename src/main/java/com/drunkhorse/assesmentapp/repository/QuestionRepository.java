package com.drunkhorse.assesmentapp.repository;

import com.drunkhorse.assesmentapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findAllByExam_Id(Long examId);

    @Query(value = "SELECT q.id FROM question q " +
            " INNER JOIN exam e on e.id = q.exam_id " +
            " WHERE e.id = :examId " +
            " ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Long getRandomQuestionIdForExam(Long examId);

    @Query(value = "SELECT q.* FROM question q" +
            " WHERE q.id > :questionId " +
            " AND q.exam_id = :examId ORDER BY q.id LIMIT 1",
            nativeQuery = true)
    Optional<Question> getNextQuestion(Long questionId, Long examId);

    @Query(value = "SELECT q.* FROM question q " +
            " WHERE q.exam_id = :examId " +
            " ORDER BY q.id LIMIT 1", nativeQuery = true)
    Optional<Question> findFirst(Long examId);

}

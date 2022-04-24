package com.drunkhorse.assesmentapp.repository;

import com.drunkhorse.assesmentapp.model.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    Page<Exam> findAll(Pageable pageable);

    @Query(value = "SELECT DISTINCT ex.* FROM exam ex " +
            " INNER JOIN exam_to_tag ett ON ex.id = ett.exam_id " +
            " INNER JOIN exam_tag et ON ett.exam_tag_id = et.tag " +
            " WHERE et.tag IN (:tags)", nativeQuery = true)
    List<Exam> findAllByTags(List<String> tags, Pageable pageable);
}

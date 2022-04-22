package com.drunkhorse.assesmentapp.repository;

import com.drunkhorse.assesmentapp.model.ExamTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamTagsRepository extends JpaRepository<ExamTag, String> {
}

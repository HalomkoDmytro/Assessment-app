package com.drunkhorse.assesmentapp.service.impl;

import com.drunkhorse.assesmentapp.converter.QuestionConverter;
import com.drunkhorse.assesmentapp.exeption.ResourceNotFoundException;
import com.drunkhorse.assesmentapp.model.Answer;
import com.drunkhorse.assesmentapp.model.Exam;
import com.drunkhorse.assesmentapp.model.Question;
import com.drunkhorse.assesmentapp.model.dto.QuestionDto;
import com.drunkhorse.assesmentapp.repository.AnswerRepository;
import com.drunkhorse.assesmentapp.repository.QuestionRepository;
import com.drunkhorse.assesmentapp.service.ExamService;
import com.drunkhorse.assesmentapp.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final ExamService examService;
    private final AnswerRepository answerRepository;

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public Question getById(Long id, boolean hideAnswer) {
        Question question = findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        if(hideAnswer) {
            question.setAnswers(null);
            question.setExplanationAnswer(null);
        }
        return question;
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> findAllByExamId(Long examId) {
        return questionRepository.findAllByExam_Id(examId);
    }

    @Override
    public Question createOrUpdate(QuestionDto dto) {
        Exam exam = examService.findById(dto.examId()).orElseThrow(ResourceNotFoundException::new);
        Question question = QuestionConverter.convert(dto);
        question.setExam(exam);
        question = createOrUpdate(question);
        return question;
    }

    @Override
    public Question createOrUpdate(Question question) {
        List<Answer> answers = question.getAnswers();
        final Question updatedQuestion = questionRepository.save(question);
        answers.forEach(answer -> answer.setQuestion(updatedQuestion));
        answerRepository.saveAll(answers);
        return updatedQuestion;
    }

    @Override
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public List<Question> findAllByExamIdLimit(Long examId, int limit) {
        List<Question> questions = questionRepository.findAllByExam_Id(examId);
        Collections.shuffle(questions);

        return questions.stream()
                .limit(limit)
                .toList();
    }

    @Override
    public Question getRandomQuestion(Long examId) {
        Long questionIdForExam = questionRepository.getRandomQuestionIdForExam(examId);
        return findById(questionIdForExam)
                .orElseThrow(ResourceNotFoundException::new);
    }
}

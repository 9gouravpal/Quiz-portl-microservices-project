package com.question.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.question.entity.Question;
import com.question.repo.QuestionRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuestionService {

	private final QuestionRepo questionRepo;

	public QuestionService(QuestionRepo questionRepo) {
		super();
		this.questionRepo = questionRepo;
	}
	
	public Question saveAllQuestion(Question question) {
		return this.questionRepo.saveAndFlush(question);
	}
	
	public List<Question> getAllQuestion(){
		return this.questionRepo.findAll();
	}
	public Question getOne(Long questionId) {
		Optional<Question> optional=this.questionRepo.findById(questionId);
		if (!optional.isPresent()) {
			throw new IllegalArgumentException("question id not found");
		}
		return optional.get();
	}
	
	public List<Question> getQuestionByQuizId(Long quizId) {
		return questionRepo.findByQuizId(quizId);
		
	}
}

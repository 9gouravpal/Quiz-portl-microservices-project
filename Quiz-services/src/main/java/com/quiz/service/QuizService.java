package com.quiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.quiz.entity.Quiz;
import com.quiz.entity.repo.QuizRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuizService {
	
	private final  QuizRepo quizRepo;
	private final QuestionClient questionClient;
	public QuizService(QuizRepo quizRepo, QuestionClient questionClient) {
		this.questionClient = questionClient;
		
		this.quizRepo = quizRepo;
	}
	
	public Quiz saveQuiz(Quiz quiz) {
		try {
			quiz=this.quizRepo.saveAndFlush(quiz);
			return quiz;
			
		} catch (Exception e) {
			log.error("Internal service error",e.getMessage());
			return null;
		}
	}
	
	public List<Quiz> getAllQuiz(){
		try {
			List<Quiz> quizs=this.quizRepo.findAll();
			for (Quiz quiz : quizs) {
				quiz.setQuestions(questionClient.getQuestionByQuizId(quiz.getId()));
				quizs.add(quiz);
			}
			return quizs;
		} catch (Exception e) {
			log.error("Data not Found",e.getMessage());
			return null;
		}
	}
	public Quiz getQuizById(Long quizId) {
		try {
			Optional<Quiz> quiz=this.quizRepo.findById(quizId);
			if (quiz.isPresent()) {
				Quiz quiz2=quiz.get();
				quiz2.setQuestions(questionClient.getQuestionByQuizId(quizId));
				return quiz2;
			}
			else {
				throw new IllegalArgumentException("quiz id not foud");
			}
			
		} catch (Exception e) {
			log.error("Internal service error.{}",quizId,e.getMessage());
			return null;
		}
	}

}

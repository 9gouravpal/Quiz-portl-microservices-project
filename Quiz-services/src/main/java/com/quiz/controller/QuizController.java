package com.quiz.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entity.Quiz;
import com.quiz.service.QuizService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/quiz")
public class QuizController {

	private final QuizService service;

	public QuizController(QuizService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/save")
	public Quiz postMethodName(@RequestBody Quiz entity) {
		return this.service.saveQuiz(entity);
	}
	
	@GetMapping("/getAll")
	public List<Quiz> getAll() {
		return this.service.getAllQuiz();
	}
	
	@GetMapping("/getOne")
	public Quiz getOne(@RequestParam("quizId") Long quizId) {
		return this.service.getQuizById(quizId);
	}
	
}

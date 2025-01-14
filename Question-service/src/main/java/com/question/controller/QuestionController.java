package com.question.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entity.Question;
import com.question.service.QuestionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/question")
public class QuestionController {

	
	private final QuestionService service;

	public QuestionController(QuestionService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/save")
	public Question postMethodName(@RequestBody Question entity) {
		
		
		return service.saveAllQuestion(entity);
	}
	
	@GetMapping("/getAll")
	public List<Question> getMethodName() {
		return service.getAllQuestion();
	}
	
	@GetMapping("/getByQuestionId")
	public Question getByQuestionId(@RequestParam Long questionId) {
		return service.getOne(questionId);
	}
	
	@GetMapping("/getQuestionByQuizId")
	public List<Question> getQuestionByQuizId(@RequestParam Long quizId) {
		return service.getQuestionByQuizId(quizId);
	}
	
	
}

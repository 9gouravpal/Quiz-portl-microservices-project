package com.quiz.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.quiz.entity.QuestionDto;

//@FeignClient(url = "http://localhost:8082",value = "Question-Client")
@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionClient {
	
   @GetMapping("/question/getQuestionByQuizId")
	List<QuestionDto> getQuestionByQuizId(Long quizId);
}

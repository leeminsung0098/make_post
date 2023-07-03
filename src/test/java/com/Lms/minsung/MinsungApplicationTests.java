package com.Lms.minsung;

import com.Lms.minsung.answer.Answer;
import com.Lms.minsung.answer.AnswerRepository;
import com.Lms.minsung.question.Question;
import com.Lms.minsung.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MinsungApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;

	@Test
	void testjpa() {
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		Answer a = new Answer();
		a.setContent("네 자동으로 생성됩니다.");
		a.setQuestion(q);
		a.setLocalDateTime(LocalDateTime.now());
		this.answerRepository.save(a);
	}

}

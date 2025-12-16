package ceu.dam.ad.apiExamenes.services;

import java.util.List;

import ceu.dam.ad.apiExamenes.model.Question;
import ceu.dam.ad.apiExamenes.model.QuestionType;

public interface QuestionService {

	Question createQuestion(Question question) throws QuestionValidateException;

	List<Question> getAllQuestions();

	List<QuestionType> getAllQuestionTypes();

	List<Question> getAllQuestionByType(String typeCode);

	Question getQuestionById(Long id) throws QuestionNotFoundException;

	Question updateQuestion(Question question) throws QuestionNotFoundException, QuestionValidateException;

	void deleteQuestion(Long id);
}

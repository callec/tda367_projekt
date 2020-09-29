package com.down_to_earth_rats.quiz_game.Model.QuestionRepository;

import com.down_to_earth_rats.quiz_game.Model.QuestionData.IQuestion;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Carl Bergman, Louise Tranborg
 *
 * This interface defines the behaviour of QuestionProviders.
 */

public interface IQuestionProvider {

    public Iterator<IQuestion> getQuestions(String subject, int numberOfQuestions);
    public Iterator<IQuestion> getQuestions(List<String> listOfSubjects, int numberOfQuestions);
}

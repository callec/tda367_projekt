package com.down_to_earth_rats.quiz_game.QuizPackage.QuestionHandler;

import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData.IQuestion;

import java.util.Iterator;

/**
 * Created by Erik Blomberg, Louise Tranborg
 *
 * This class is responsible for instantiating a IQuestionHandler objects,
 * loading them with questions.
 *
 */

public abstract class QuestionHandlerFactory {

    public static IQuestionHandler createRandomizingHandler(Iterator<IQuestion> questions){
        return new RandomizingQuestionHandler(questions);

    }

}

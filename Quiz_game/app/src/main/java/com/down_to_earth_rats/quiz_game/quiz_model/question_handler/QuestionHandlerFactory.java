package com.down_to_earth_rats.quiz_game.quiz_model.question_handler;

import com.down_to_earth_rats.quiz_game.quiz_model.question_data.IQuestion;

import java.util.Iterator;

/**
 * Created by Erik Blomberg, Louise Tranborg
 * <p>
 * This class is responsible for instantiating a IQuestionHandler objects,
 * loading them with questions.
 */

public abstract class QuestionHandlerFactory {

    public static IQuestionHandler createRandomizingHandler(Iterator<IQuestion> questions) {
        return new RandomizingQuestionHandler(questions);

    }

}

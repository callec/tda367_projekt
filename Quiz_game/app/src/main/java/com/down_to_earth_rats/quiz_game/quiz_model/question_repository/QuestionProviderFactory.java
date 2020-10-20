package com.down_to_earth_rats.quiz_game.quiz_model.question_repository;

/**
 * Created by Carl Bergman, Louise Tranborg
 *
 *
 */

public abstract class QuestionProviderFactory {

    public static IQuestionProvider getQuestionProvider(){
        return new SimpleQuestionProvider();
    }
}

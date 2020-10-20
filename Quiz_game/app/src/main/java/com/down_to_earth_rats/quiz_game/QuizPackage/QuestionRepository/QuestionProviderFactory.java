package com.down_to_earth_rats.quiz_game.QuizPackage.QuestionRepository;

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

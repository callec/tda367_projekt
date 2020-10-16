package com.down_to_earth_rats.quiz_game.QuizPackage.QuestionRepository;

/**
 * Created by Carl Bergman, Louise Tranborg
 *
 *
 */

public class QuestionProviderFactory {

    private QuestionProviderFactory() {
    }

    public static IQuestionProvider getStandardQuestionProvider(){
        return new ConcreteQuestionProvider();
    }
}

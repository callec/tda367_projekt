package com.down_to_earth_rats.quiz_game.quiz_model.question_repository;

/**
 * Created by Carl Bergman, Louise Tranborg
 * <p>
 * Create different types of question providers.
 */

public abstract class QuestionProviderFactory {

    /**
     * Get a question provider, currently only one, SimpleQuestionProvider, implemented.
     *
     * @return IQuestionProvider an instance of its subclass.
     */
    public static IQuestionProvider getQuestionProvider() {
        return new SimpleQuestionProvider();
    }
}
